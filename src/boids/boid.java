package boids;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.exp;
import static java.lang.StrictMath.sqrt;
import java.util.ArrayList;
import java.util.Random;
import math.NDistance;
import math.trigonometric;
import math.vector2d;
import simulation.bucket;

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
    float colorVelH,colorLeadH,colorPredH;
    float colorSepH,colorCohH,colorAliH;
    float colorOdstVelH,colorOdstVelLokalH;
    boolean zderzony,bum;
    boolean hungry;
    int eats;
    boolean havePredator;
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
        colorPredH=0.75f;
        colorSeparB=0.0f;
        colorVelB=0.0f;
        colorAccelB=0.0f;
        colorSepH=0;colorCohH=0;colorAliH=0;
        colorOdstVelH=0;
        colorOdstVelLokalH=0;
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
        havePredator=false;
    }

    public vector2d separate(ArrayList<boid> boids) {
        vector2d value = new vector2d(0,0);
        vector2d pos,bestPos;
        colorSepH=0;
        int k = 0;
        double dist;
        double acumDist=0;
        for (int i = 0; i < boids.size(); i++) {
            //bestPos=this.position.getCloserPosition(boids.get(i).position, mainBoids.panelSizeX, mainBoids.panelSizeY);
            bestPos=this.getBestPosition(boids.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY);
            dist = this.position.getDistance(bestPos);
            acumDist+=dist;
             if(dist>separateRadius){continue;}
            if (dist <= minimalDistance) {
                mainBoids.stat.incCollisonNumber();
                velocity.multi(0.90);
                pos=this.getPosition().getVec().minus(bestPos);
                colorSepH=0;
                return pos.div(dist);
            }
                pos=this.getPosition().getVec().minus(bestPos);
                pos.divNonZero(dist);
                pos.multi(exp(-((dist-minimalDistance)*(dist-minimalDistance))/(separateRadius)));
                //pos.divNonZero(dist-minimalDistance+1);
                value.add(pos);
                k++;
        }
        
        if (k > 0) {
            mainBoids.stat.addAverageDist(acumDist/k);
            value.divNonZero(k);
//            if(acumDist/k<30){this.maxSpeed*=0.9;if (maxSpeed<50){maxSpeed=50;}}
//            if(acumDist/k>30){this.maxSpeed=150;}
           this.seColorSepH((float)value.getLength());
           // this.seColorSepH((float)((acumDist/k)/separateRadius));
            return  value;
           
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
            if(boids.get(i).getType()!=2){continue;}
            sDist = this.position.getSDistance(boids.get(i));
            if (sDist < minimalDistance * minimalDistance*5) {
             //   if (sDist == 0) {sDist = 0.000000001;}
                pos=this.getPosition().getVec().minus(boids.get(i).position);
                pos.div(sDist);
                value.add(pos);k++;
            }
        }

        value.div(k);
        return value.normalize();
    
    }
    public vector2d alignment(ArrayList<boid> boids) {
        vector2d pos = new vector2d(0, 0);
        int k=0;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type<2){pos.add(boids.get(i).velocity);k++;}
        }      
            if (k>0){
            pos.divNonZero(k);
            float tempVar=(float)(((pos.getVec().normalize().skalarny(this.velocity.getVec().normalize()))-1)/(-2));
            this.setColorOdstVelLokalH(tempVar);
            mainBoids.stat.addOdstAverageSpeed(tempVar);
            pos.minus(this.velocity);
            return pos.normalize();
            }else{return pos;}
    }
    public vector2d cohesion(ArrayList<boid> boids) {
        vector2d pos = new vector2d(0, 0);
        vector2d bestPos;
        int k=0;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type<2){
            //bestPos=this.position.getCloserPosition(boids.get(i).position, mainBoids.panelSizeX, mainBoids.panelSizeY); 
            bestPos=this.getBestPosition(boids.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY);
             if( this.position.getSDistance(bestPos)>minimalDistance*minimalDistance ){//pominiecie najblizszych
            pos.add(bestPos);
            k++;
             }
             
            }
        }
        if (k>0){
        pos.divNonZero(k);
        pos.minus(this.position);
//        if(pos.getLength()<minimalDistance){
//          //  System.out.println(pos.getLength());
//        return pos.normalize().;
//        }
        return pos.normalize();
       // System.out.println(velocity.getLength()/this.maxSpeed);
         // return pos.normalize().multi((((velocity.getLength())/(this.maxSpeed))+3)/4);
        }else{return pos;}
        
    }

    public vector2d followLeader(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);
        if (type == 0) {return value; }
        vector2d bestPos;
        boid leader = null;
        this.colorLeadH=0;
        double dist;
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type == 0) {
                //bestPos=this.position.getCloserPosition(boids.get(i).position, mainBoids.panelSizeX, mainBoids.panelSizeY);
                  bestPos=this.getBestPosition(boids.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY);
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
            this.colorLeadH=(1-(float)(dist/mainBoids.simul.radiusNeigh))*0.75f;
            //pos.minus(leader.getVelocity().getVec().normalize().multi(15));
           // bestPos=this.position.getCloserPosition(leader.position, mainBoids.panelSizeX, mainBoids.panelSizeY);
            bestPos=this.getBestPosition(leader, mainBoids.panelSizeX, mainBoids.panelSizeY);
            value = bestPos.minus(this.position);
            if (dist > skala*5) {
                return value.divNonZero(dist);
            } else {
                return value.div(dist).multi(dist / (skala*5));
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
        if (this.type != 0) {// zrobic opcje dla wszystkich
            return value;
        }

        double d;
        if (aim.getX() < 0 && aim.getY() < 0) {
            if (aims == null || indexAims == -1) {
                return value;
            }
            value = aims.get(indexAims).getVec().minus(this.position);
            d = value.getSLength();
            if (d < 5*skala*5*skala) {
                if (indexAims >= aims.size() - 1) {
                    indexAims = 0;
                } else {
                    indexAims++;
                }
            }
        } else {
            value = aim.getVec().minus(this.position);
            d = value.getSLength();

        }

        if (d >10*skala*10*skala) {
            value.normalize();
        } else {
            value.normalize().multi(d / (10*skala*10*skala));
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
        vector2d jedziem=new vector2d(0,0);
        double s;
        Random randGen;
        double kat;
        Food target;
        ArrayList<Food> seeFood;
        if(this.hungry) {
            seeFood=new ArrayList<>();
            randGen=new Random();
            for(int i=0;i<jedzonko.size();i++)
            {   
                   s=this.position.getDistance(jedzonko.get(i).fpos);
                   if(s<=mainBoids.mainWin.getForagingDistance())
                   {
                       
                        kat=this.calcAngle((jedzonko.get(i).fpos));
                        if(s<skala*20) seeFood.add(jedzonko.get(i));
                        else {
                            if((3.1415-kat)<kat_widzenia)
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
        }else{return jedziem;}
            return jedziem.multi(2);
    }
    //---------------------------------------------------------------
    public void applyForce(double step) {
        velocity.add(acceleration);
        if (velocity.getSLength() > maxSpeed*maxSpeed) {    
            velocity.normalize();
       //     if(this.getType()==2) velocity.multi(maxSpeed*0.77); //wolniejszy drapieżnik
            velocity.multi(maxSpeed);
            colorVelH=0;
        }else{
            colorVelH=(1-(float)(velocity.getSLength()/(maxSpeed*maxSpeed)))*0.75f;
        }
    }

    public void move(double step) {
        vector2d temp = velocity.getVec();
        position.add(temp.multi(step));
        //velocity.multi(0.9);
        //System.out.println(velocity.getLength());
        double maxX = mainBoids.panelSizeX;
        double maxY = mainBoids.panelSizeY;
        // velocity.multi(0.1);
        if (position.getX() < 0) {
            position.setX(maxX + position.getX());
        }
        else if (position.getX() > maxX) {
            position.setX(position.getX() - maxX);
        }
        if (position.getY() < 0) {
            position.setY(maxY + position.getY());
        }
        else if (position.getY() > maxY) {
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
        double k1 = (pos.getX() * this.velocity.getX() + pos.getY() * this.velocity.getY()) / (sqrt(pos.getSLength() * this.velocity.getSLength()));
        k1 = trigonometric.acosLUT(k1);
        return k1;
    }

    public vector2d getAcceleration() {
        return this.acceleration;
    }
    public void setAcceleration(vector2d _accel) {

        if (_accel.getSLength() > maxForce*maxForce) {
            _accel.normalize();
            _accel.multi(maxForce);
        }
        _accel.divNonZero(masa);
        this.acceleration = _accel;
    colorAccelB=1-(float)(_accel.getSLength()/(maxForce*maxForce));
    }
    /**
     * Funkcja realizująca "widzenie przez ściany", zamiast getPosition()
     * @param osobnik
     * @param sizeX rozmiar pola symulacji
     * @param sizeY rozmiar pola symulacji
     * @return zwraca pozycję, w której boid wywołujący funkcję powinien widzieć boida podanego w argumencie
     */
    public vector2d getBestPosition(boid osobnik,int sizeX,int sizeY){
     vector2d tempPosition;
     int difx=osobnik.getBucketX()-this.getBucketX();
     int dify=osobnik.getBucketY()-this.getBucketY();
        tempPosition=osobnik.getPosition().getVec();
        
     if (abs(difx)<=1){}
     else if (difx>2){tempPosition.add(-sizeX,0);}
     else if (difx<-2){tempPosition.add(sizeX,0);}
     if (abs(dify)<=1){}
     else if (dify>2){tempPosition.add(0,-sizeY);}
     else if (dify<-2){tempPosition.add(0,sizeY);}
     return tempPosition;
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
    public void setHavePredator(boolean b){
    havePredator=b;
    }
    public boolean getHavePredator(){
    return havePredator;
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
    public void setBucket(int _x, int _y) {
        koszX = _x;
        koszY = _y;
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
    public float getColorSepH(){
    return colorSepH;
    }
    public float getColorAliH(){
    return colorAliH;
    }
    public float getColorCohH(){
    return colorCohH;
    }
    public float getColorLeadH(){
    return colorLeadH;
    }
    public float getColorVelH(){
    return colorVelH;
    }
    public float getColorOdstVelH(){
    return colorOdstVelH;
    }
    public float getColorOdstVelLokalH(){
    return colorOdstVelLokalH;
    }
    public float getColorPredH(){
    return colorPredH;
    }
    public void setColorOdstVelH(float H){
    colorOdstVelH=(H*240f/360)*(-1)+240f/360;
    }
    public void setColorOdstVelLokalH(float H){
    colorOdstVelLokalH=(H*240f/360)*(-1)+240f/360;
    }
    public void seColorSepH(float H){
    colorSepH=(H*240f/360)*(-1)+240f/360;
    }
    public boolean czyBum(){
        return bum;
    }
    public double getMinimalDist(){
        return minimalDistance;
    }
    //public boolean czyOmijam(){
    //return omijam;
    //}
    public boolean isHungry(){
        return hungry;
    }
       
}
