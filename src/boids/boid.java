package boids;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.sqrt;
import java.util.ArrayList;
import java.util.Random;
import math.NDistance;
import math.trigonometric;
import math.vector2d;
import simulation.bucket;
import trunk.src.boids.Obstacle;

/**
 * @author Tomek
 */
public class boid {

    vector2d position, velocity, acceleration, aim;
    ArrayList<vector2d> aims = null;
    int indexAims;
    int koszX, koszY;
    public double radius;
    double maxSpeed, maxForce;
    double masa;
    double skala;
    int type;
    double katWidzenia;
    double minimalDistance;
    double separateRadius;
    float colorLeadB,colorSeparB,colorVelB,colorAccelB;
    boolean zderzony,bum;
    boolean hungry;
    int eats;
    
    public boid(double x, double y) {
        Random randGen = new Random();
        acceleration = new vector2d(0, 0);
        velocity = new vector2d(0, 0);
        position = new vector2d(x, y);
        radius = 2;
        skala=1;
        indexAims = -1;
        maxSpeed = 3;
        maxForce = 2.5;
        colorLeadB=0.0f;
        colorSeparB=0.0f;
        colorVelB=0.0f;
        colorAccelB=0.0f;
        masa=0.08;
        //omijam=false;
        zderzony=false;
        bum=false;
        hungry=false;
        // angle=randGen.nextDouble()*360;
        minimalDistance = 0.2;
        type = 1;
        katWidzenia = 2.6;
        eats=0;
        separateRadius=4;
    }

    public vector2d separate(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);
        vector2d bestPos;
        if (type == 3 || type == 0 || type == 2 || boids.isEmpty()) {return value;}
        vector2d pos;
        colorSeparB=0;
        int k = 0;
        double dist;
        double acumDist=0;
        for (int i = 0; i < boids.size(); i++) {
            bestPos=this.position.getCloserPosition(boids.get(i).position, 1072, 677);
  
            dist = this.position.getDistance(bestPos);
            acumDist+=dist;
             if(dist>separateRadius){continue;}
            if (dist < minimalDistance) {             
                pos=this.getPosition().getVec().minus(bestPos);
                return pos.normalize();
            }
           
                pos=this.getPosition().getVec().minus(bestPos);
                pos.div(dist);
                pos.div(dist-minimalDistance+1);
                value.add(pos);
                k++;
        }
        
        if (k > 0) {
            mainBoids.stat.addAverageDist(acumDist/k);
            return  value.div(k);
            //colorSeparB=1-(float)(pos.getLength()/(minimalDistance * minimalDistance));
        } else {
            return value;
        }

    }
    
    public vector2d separatePredator(ArrayList<boid> boids){
     vector2d value = new vector2d(0, 0);
     vector2d pos;
  
        int k = 0;
        double sDist;
        for (int i = 0; i < boids.size(); i++) {
            if(boids.get(i).getType()==2){continue;}
            sDist = this.position.getSDistance(boids.get(i));
            if (sDist < minimalDistance * minimalDistance*5) {
                if (sDist == 0) {sDist = 0.000000001;}
                pos=this.getPosition().getVec().minus(boids.get(i).position);
                pos.div(sDist);
                value.add(pos);k++;
            }
        }
        if (k > 0) {
            value.div(k);
            //colorSeparB=1-(float)(pos.getLength()/(minimalDistance * minimalDistance));
        } else {
            return value;
        }

        return value.normalize();
    
    }
    public vector2d alignment(ArrayList<boid> boids) {
        vector2d pos = new vector2d(0, 0);
        if (type == 3 || type == 2 || boids.isEmpty() || type == 0) {return pos;}
        int k=0;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type==1){
            pos.add(boids.get(i).velocity);k++;}
        }      
            if (k>0){
            pos.div(k).minus(this.velocity);
            return pos.normalize();
            }else{return pos;}
    }
    public vector2d cohesion(ArrayList<boid> boids) {
        vector2d pos = new vector2d(0, 0);
        vector2d bestPos;
        if (type == 3 || type == 2 || type == 0 || boids.size() == 0) {return pos;}
        int k=0;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type==1){
            bestPos=this.position.getCloserPosition(boids.get(i).position, 1072, 677);     
            pos.add(bestPos);
            k++;
            }
        }
        if (k>0){
        pos.div(k);
        pos.minus(this.position);
        return pos.normalize();
        }else{return pos;}
        
    }

    public vector2d followLeader(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0); 
        vector2d bestPos;
        if (type == 3 || type == 2 || type == 0 || boids.isEmpty()) {return value; }
        boid leader = null;
        this.colorLeadB=0;
        double dist;
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type == 0) {
                bestPos=this.position.getCloserPosition(boids.get(i).position, 1072, 677);
                dist = this.getPosition().getDistance(bestPos);
                if (dist < minDist) {
                    leader = boids.get(i);
                    minDist = dist;
                }
            }
        }
        if (leader != null) {
            mainBoids.stat.incBoidHaveLeader();
            dist=minDist;
            this.colorLeadB=1-(float)(dist/mainBoids.simul.radiusNeigh);
            //pos.minus(leader.getVelocity().getVec().normalize().multi(15));
            bestPos=this.position.getCloserPosition(leader.position, 1072, 677);
            value = bestPos.getVec().minus(this.position);
            if (dist > minimalDistance*2) {
                return value.div(dist);
            } else {
                return value.normalize().multi(dist / minimalDistance*2);
            }
        } else {
            return value;
        }

    }

    /**
     * Odległość od prostej wyznaczonej przez kierunek boida
     *
     * @param ob
     * @return
     */
    double getOdl(Obstacle ob) {
        //double wsp; //współczynnik prostej w układzie
        //wsp = velocity.getY()/velocity.getX();
        double a = velocity.getY();
        double b = (-1) * velocity.getX();
        double c = (-1) * (a * position.getX() + b * position.getY());
        double odl = abs(a * ob.getPosition().getX() + b * ob.getPosition().getY() + c) / sqrt(a * a + b * b);
        odl = odl - this.radius - ob.getR(); //o ile radius to rozmiar osobnika//tak radius to jego rozmiar
        return odl;
    }
    /**
     * 
     * @param obs   tablica przeszkód do potencjalnego ominięcia
     * @param waga  <0,1> który tryb omijania został wybrany 1=tylko skręcanie
     * @param dl    długość (prawie)prostokąta w którym osobnik reaguje na przeszkody
     * @return sterowanie, póki co normalizowane
     */
    public vector2d better_avoid(ArrayList<Obstacle> obs, double waga, int dl) {
        vector2d value = new vector2d(0, 0);
        double min = Double.MAX_VALUE;
        int minn = -1;
        for (int i = 0; i < obs.size(); i++) {
            double odl = this.getOdl(obs.get(i));//szukam najbliższej przeszkody
            if (odl < min && this.velocity.skalarny(position.getX() - obs.get(i).getX(), position.getY() - obs.get(i).getY()) < 0) {
                //jeśli jesteś najbliższą prostej i jesteś przede mną, to zapamiętaj indeks
                min = odl;
                minn = i;
            }
        }
        if (minn < 0 || min > 0) {
            //omijam=false;
            bum=false;
            zderzony=false;
            return value;       // nie ma przeszkód(zwykle są), albo odległość od prostej jest dodatnia, czyli nie będzie zderzenia
        } else {                //czyli jest przeszkoda i przecina prostą
            Obstacle najblizsza = obs.get(minn);
            value.setX(position.getX() - najblizsza.getX());
            value.setY(position.getY() - najblizsza.getY());
            min=this.position.getDistance(najblizsza.getPosition())-najblizsza.getR()-2.5;//to nie jest min, ale po co nową zmienną robić jak stara niepotrzebna
            if (min>dl){//sprawdź czy nie za daleko
                    //omijam=false;
                    bum=false;
                    zderzony=false;
                    return new vector2d(0, 0);} 
                //jak blisko, to sprawdź czy jest po prawej czy po lewej
            if (min<=0){
                if(bum){zderzony=true;bum=false;}
                else {zderzony=true;bum=true;}
                return value.normalize(); //steruj naprzeciwko przeszkody jak i tak się zderzyłeś.
            }
            //omijam=true;
            if (this.velocity.getRight().skalarny(value)>0){        //to przeszkoda po lewej od wektora
                return this.velocity.getRight().normalize().multi(waga).add(value.normalize().multi(1-waga)).multi(dl/2/min);
                //to multi(dl/2/min) to jest skalowanie, żeby działało mocniej od 1 jesli bliżej niz polowa prostokata, a slabiej dalej
                }
            return this.velocity.getLeft().normalize().multi(waga).add(value.normalize().multi(1-waga)).multi(dl/2/min);
        }
    }
    
    public vector2d avoid(ArrayList<Obstacle> obs) {
        vector2d value = new vector2d(0, 0);
        double min = Double.MAX_VALUE;
        int minn = -1;
        for (int i = 0; i < obs.size(); i++) {
            double odl = this.getOdl(obs.get(i));//szukam najbliższej przeszkody
            if (odl < min) {//jeśli jesteś najbliższą, to zapamiętaj indeks
                min = odl;  //odległość najbliższej przeszkody
                minn = i;   //indeks przeszkody w tablicy
            }
        }
        if (minn < 0 || min > 0) {
            //System.out.println("Nie widzę, bo nie ma na lini żadnej przeszkody");
            return value;       // nie ma przeszkód(zwykle są), albo odległość jest dodatnia, czyli nie będzie zderzenia
        } else {                //czyli jest przeszkoda i przecina prostą
            Obstacle najblizsza = obs.get(minn);
            
            value.setX(position.getX() - najblizsza.getX());
            value.setY(position.getY() - najblizsza.getY());
            if (this.velocity.skalarny(value) < 0) {            //jeśli przeszkoda przede mną
                if (this.position.getDistance(najblizsza.getPosition())-najblizsza.getR()>50){
                    return new vector2d(0, 0);} //to sprawdź czy nie za daleko, 50 to (długość prostokąta-pomijalna wielkość osobnika)
                //jak blisko, to sprawdź czy jest po prawej czy po lewe
                //System.out.println("Będę omijał");
                if (this.velocity.getRight().skalarny(value)>0){        //to przeszkoda po lewej od wektora
                    //System.out.println("!@#$%, przeszkoda po lewej");
                    return this.velocity.getRight().normalize();
                }
                //System.out.println("!@#$%, przeszkoda po prawej");
                return this.velocity.getLeft().normalize();
            } else {
                //System.out.println("Nie widzę, bo za mną");
                return new vector2d(0, 0);
            }
        }
    }

    public vector2d goToAim(vector2d aim) {
        vector2d value = new vector2d(0, 0);
        if (this.type != 0) {
            return value;
        }

        double d;
        if (aim.getX() < 0 && aim.getY() < 0) {
            if (aims == null || indexAims == -1) {
                return value;
            }
            value = aims.get(indexAims).getVec().minus(this.position);
            d = value.getLength();
            if (d < 28) {
                if (indexAims >= aims.size() - 1) {
                    indexAims = 0;
                } else {
                    indexAims++;
                }
            }
        } else {
            value = aim.getVec().minus(this.position);
            d = value.getLength();

        }

        if (d > 60) {
            value.normalize();
        } else {
            value.normalize().multi(d / 60);
        }

        return value;
    }
    //--------------------------------------------
    /**
     * Udaje zachowanie wobec drapieżnika
     *
     * @param boids
     * @return
     */
    public vector2d predator(ArrayList<boid> boids) {
        vector2d wynik;
        wynik = PBehaviour.escapeP(this, boids);

        return wynik;
    }

    /**
     * Udaje zachowanie drapieżnika
     *
     * @param pred
     * @param boids
     * @param wszystkie
     * @return
     */
    public vector2d predHunt(ArrayList<boid> boids,ArrayList<bucket> bucketboids) {
        vector2d wynik;
        wynik = PBehaviour.huntP(this, boids,bucketboids);
        return wynik;
    }

    /**
     * Udaje zachowanie wobec jedzenia
     * @param jedzonko
     * @param kat_widzenia
     * @return 
     */
    public vector2d foraging(ArrayList<Food> jedzonko,double kat_widzenia)
    {
        double s;
        Random randGen=new Random();
        double kat;
        Food target;
        vector2d jedziem=new vector2d(0,0);
        ArrayList<Food> seeFood=new ArrayList<Food>();
        if(this.getType()==2) return jedziem;
        
        if(this.hungry) {
            for(int i=0;i<jedzonko.size();i++)
            {
                   s=this.position.getDistance(jedzonko.get(i).fpos);
                   if(s<=mainBoids.mainWin.getForagingDistance())
                   {
                        kat=this.calcAngle((jedzonko.get(i).fpos));
                        if(s<25*25) seeFood.add(jedzonko.get(i));
                        else {
                            if((180-kat)<kat_widzenia*180/3.1415)
                            {
                                 seeFood.add(jedzonko.get(i));
                            }
                        }
                   
                  }
                  target=NDistance.minFood(this,seeFood);
                  if(target!=null)
                  {
                    if(this.getPosition().getDistance(target.getPos())<=9)
                    {
                          mainBoids.simul.foraging_situation=true;
                          this.velocity=new vector2d(0,0);
                          eats++;
                          if(eats>=1200) 
                          {
                              hungry=false;
                              return new vector2d(randGen.nextDouble()-2,randGen.nextDouble()+4).normalize();
                          }
                        //jedziem.add(this.velocity);
                        // jedziem.multi(-14);
                          if(target.iam_eating())
                          {
                              jedzonko.remove(target);
                              mainBoids.simul.pom.clear();
                              mainBoids.simul.pom.addAll(mainBoids.obs);
                              mainBoids.simul.pom.addAll(mainBoids.food);
           
                          }
                    }
                    else {
                         mainBoids.simul.foraging_situation=true;
                         jedziem.add(target.fpos);
                         jedziem.minus(this.getPosition());
                         jedziem.normalize();
                    }
                }
            }
        }
            return jedziem.multi(2);
    }
    //---------------------------------------------------------------
    public void applyForce(double step) {
     //   System.out.println("a"+velocity.getLength());
        velocity.add(acceleration.multi(1));
        if (velocity.getLength() > maxSpeed) {    
            velocity.normalize();
            velocity.multi(maxSpeed);
            colorVelB=0;
        }else{
            colorVelB=1-(float)(velocity.getSLength()/(maxSpeed*maxSpeed));
        }
    }

    public void move(double step) {
        vector2d temp = velocity.getVec();
        position.add(temp.multi(step));
        //velocity.multi(0.9);
        //System.out.println(velocity.getLength());
        double maxX = 1072;
        double maxY = 677;
        // velocity.multi(0.1);
        if (position.getX() < 0) {
            position.setX(maxX + position.getX());
        }
        if (position.getX() > maxX) {
            position.setX(position.getX() - maxX);
        }
        if (position.getY() < 0) {
            position.setY(maxY + position.getY());
        }
        if (position.getY() > maxY) {
            position.setY(position.getY() - maxY);
        }
    }

    public double calcAngle() {
        double k1;
        if (velocity.getX() != 0) {
            k1 = Math.atan(velocity.getY() / velocity.getX());
        } else {
            k1 = Math.atan(velocity.getY() / 0.0000000001);
        }
        return k1;
    }

    public double calcAngle(vector2d _pos) {
        vector2d pos = this.getPosition().getVec();
        pos.minus(_pos);
        double k1 = (pos.getX() * this.velocity.getX() + pos.getY() * this.velocity.getY()) / (pos.getLength() * this.velocity.getLength());
        k1 = trigonometric.acosLUT(k1) * 180 / 3.1415;
        return k1;
    }

    public vector2d getAcceleration() {
        return this.acceleration;
    }
    public void setAcceleration(vector2d _accel) {
        _accel.div(masa);
        if (_accel.getSLength() > maxForce*maxForce) {
            _accel.normalize();
            _accel.multi(maxForce);
        }
        this.acceleration = _accel;
    colorAccelB=1-(float)(_accel.getSLength()/(maxForce*maxForce));
    }
    public vector2d getPosition() {
        return this.position;
    }
    public vector2d getVelocity() {
        return this.velocity;
    }
    public double getMaxSpeed() {
        return this.maxSpeed;
    }
    public void setPosition(vector2d _pos) {
        this.position = _pos;
    }
    public void setType(int _type) {
        type=_type;
    }
    public double getX() {
        return position.getX();
    }
    public double getY() {
        return position.getY();
    }
    public double getR() {
        return radius;
    }
    public int getType() {
        return type;
    }
    public boolean setBucket(int _x, int _y) {
        koszX = _x;
        koszY = _y;
        return true;
    }
    public boolean checkBucketXY(int _x, int _y) {
        return koszX != _x || koszY != _y;
    }
    public int getBucketX() {
        return koszX;
    }
    public int getBucketY() {
        return koszY;
    }
    public float getColorLeadB(){
    return colorLeadB;
    }
    public float getColorSeparB(){
    return colorSeparB;
    }
    public float getColorVelB(){
    return colorVelB;
    }
    public float getColorAccelB(){
    return colorAccelB;
    }
    public boolean czyBum(){
        return bum;
    }
    //public boolean czyOmijam(){
    //return omijam;
    //}
    public boolean isHungry(){
        return hungry;
    }
       
}
