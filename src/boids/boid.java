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
    double angle;
    public double radius;
    double maxSpeed, maxForce;
    int type, eats;
    double katWidzenia;
    double minimalDistance;
    float colorLeadB;
    float colorSeparB;
    float colorVelB;
    float colorAccelB;
    boolean omijam;
    
    
    public boid(double x, double y) {
        Random randGen = new Random();
        acceleration = new vector2d(0, 0);
        velocity = new vector2d(0, 0);
        position = new vector2d(x, y);
        radius = 7;
        indexAims = -1;
        maxSpeed = 1;
        maxForce = 0.5;
        colorLeadB=0.0f;
        colorSeparB=0.0f;
        colorVelB=0.0f;
        colorAccelB=0.0f;
        omijam=false;
        
        // angle=randGen.nextDouble()*360;
        minimalDistance = 8;
        type = 1;
        eats = -1;
        katWidzenia = 0.5;
    }

    public vector2d separate(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);
        vector2d pos = new vector2d(0, 0);
        colorSeparB=0;
        int k = 0;
        double sDist;
        if (type == 3 || type == 0 || type == 2 || boids.isEmpty()) {
            return value;
        }
        for (int i = 0; i < boids.size(); i++) {
            sDist = this.position.getSDistance(boids.get(i));
            if (sDist < minimalDistance * minimalDistance) {
                if (sDist == 0) {sDist = 0.000000001;}              
                pos=this.getPosition().getVec().minus(boids.get(i).position);
                pos.div(sDist);
                value.add(pos);
                k++;
            }
        }
        if (k > 0) {
            value.div(k);
            //colorSeparB=1-(float)(pos.getLength()/(minimalDistance * minimalDistance));
        } else {
            return value;
        }
        //-----------------------------
        //Żeby zwiększyć separację dla drapieżników
      //  if(type==2) return value;
        //-----------------------------
        return value.normalize();
    }
    public vector2d separatePredator(ArrayList<boid> boids){
     vector2d value = new vector2d(0, 0);
     vector2d pos = new vector2d(0, 0);
        int k = 0;
        double sDist;
        for (int i = 0; i < boids.size(); i++) {
            if(boids.get(i).getType()==2){continue;}
            sDist = this.position.getSDistance(boids.get(i));
            if (sDist < minimalDistance * minimalDistance) {
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
        //-----------------------------
        //Żeby zwiększyć separację dla drapieżników
      //  if(type==2) return value;
        //-----------------------------
        return value.normalize();
    
    }
    public vector2d alignment(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);

        vector2d pos = new vector2d(0, 0);
        if (type == 3 || type == 2 || boids.isEmpty() || type == 0) {
            return value;
        }
        for (int i = 0; i < boids.size(); i++) {
            pos.add(boids.get(i).velocity);
        }
        if (!boids.isEmpty()) {
            pos.div(boids.size()).minus(this.velocity);//ten minus nie wiem co robi
            return pos.normalize();
        } else {
            return pos.normalize();
        }
    }

    public vector2d cohesion(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);
        vector2d pos = new vector2d(0, 0);
        if (type == 3 || type == 2 || type == 0 || boids.size() == 0) {
            return value;
        }
        for (int i = 0; i < boids.size(); i++) {
            pos.add(boids.get(i).position);
        }
        pos.div(boids.size());
        value = pos.minus(this.position);
        return value.normalize();
    }

    public vector2d followLeader(ArrayList<boid> boids) {
        vector2d value = new vector2d(0, 0);
        vector2d pos;
        this.colorLeadB=0;
        boid leader = null;
        if (type == 3 || type == 2 || type == 0 || boids.isEmpty()) {
            return value;
        }

        double dist = 1;
        double minDist = 100000000;
        for (int i = 0; i < boids.size(); i++) {
            if (boids.get(i).type == 0) {
                //pos.add(boids.get(i).getPosition());
                dist = this.getPosition().getDistance(boids.get(i));
                if (dist < minDist) {
                    leader = boids.get(i);
                    minDist = dist;
                }
            }
        }
        if (leader != null) {
            pos = leader.getPosition().getVec();
            this.colorLeadB=1-(float)(dist/mainBoids.simul.radiusNeigh);
            //pos.minus(leader.getVelocity().getVec().normalize().multi(15));
            value = pos.minus(this.position);
            if (dist > 12) {
                return value.div(dist);
            } else {
                return value.normalize().multi(dist / 12);
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
            //NIEprawidłowe, użyte do testów if (odl < min ) {
                //jeśli jesteś najbliższą i jesteś przede mną, to zapamiętaj indeks
                min = odl;  //odległość najbliższej przeszkody
                minn = i;   //indeks przeszkody w tablicy
            }
        }
        if (minn < 0 || min > 0) {
            omijam=false;
            return value;       // nie ma przeszkód(zwykle są), albo odległość jest dodatnia, czyli nie będzie zderzenia
        } else {                //czyli jest przeszkoda i przecina prostą
            Obstacle najblizsza = obs.get(minn);
            value.setX(position.getX() - najblizsza.getX());
            value.setY(position.getY() - najblizsza.getY());
            if (this.position.getDistance(najblizsza.getPosition())-najblizsza.getR()-2.5>dl){
                    omijam=false;
                    return new vector2d(0, 0);} //sprawdź czy nie za daleko, dl to (długość prostokąta-2.5[czyli promien osobnika])
                //jak blisko, to sprawdź czy jest po prawej czy po lewej
            omijam=true;
            //System.out.println("Getdistance do środka przeszkody: " + this.position.getDistance(najblizsza.getPosition()) +" - promien przeszkody: "+najblizsza.getR() +" -2.5 = "+(this.position.getDistance(najblizsza.getPosition())-najblizsza.getR()-5)+ "a prostokat ma: " + dl);
            if (this.velocity.getRight().skalarny(value)>0){        //to przeszkoda po lewej od wektora
                return this.velocity.getRight().normalize().multi(waga).add(value.normalize().multi(1-waga));
                }
            return this.velocity.getLeft().normalize().multi(waga).add(value.normalize().multi(1-waga));
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

    public vector2d worse_avoid(ArrayList<Obstacle> obs) {
        vector2d value = new vector2d(0, 0);
        double min = Double.MAX_VALUE;
        int minn = -1;
        for (int i = 0; i < obs.size(); i++) {//poprawic getdistance do innej klasy ma byc
            double odl = this.getOdl(obs.get(i));//szukam najbliższej przeszkody
            if (odl < min) {
                min = odl;  //odległość najbliższej przeszkody
                minn = i;   //indeks przeszkody w tablicy
            }
        }
        if (minn < 0 || min > 0) {
            //System.out.println("Nie widzę, bo nie ma na lini żadnej przeszkody");
            return value; // nie ma przeszkód, nie powinno się zdarzyć przy przeglądaniu wszystkich na planszy, albo odległość jest dodatnia, czyli nie będzie zderzenia
        } else {    //czyli jest zderzenie
            //WCALE NIE wyliczam wektor linii łączącej środek boida ze środkiem przeszkody skierowany do środka przeszkody
            //tylko steruję prostopadle do kierunku poruszania się boida z dopadowaną wartością
            Obstacle najblizsza = obs.get(minn);
            
            value.setX(position.getX() - najblizsza.getX());
            value.setY(position.getY() - najblizsza.getY());
            if (this.velocity.skalarny(value) < 0) {
                if (this.position.getDistance(najblizsza.getPosition())-najblizsza.getR()>50){return new vector2d(0, 0);} //to jesli jest za daleko, powinno być parametryzowalne
                //to steruj bo przeszkoda przed tobą, na razie steruj źle bardziej zwalniając niż skręcając
                //System.out.println("Dzień dobry, widzę przeszkodę");
                return value.normalize();
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
            if (d < 10) {
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

        if (d > 100) {
            value.normalize();
        } else {
            value.normalize().multi(d / 100);
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
    public vector2d predHunt(ArrayList<boid> boids,ArrayList<bucket> bucketboids, ArrayList<boid> wszystkie) {
        vector2d wynik;
        wynik = PBehaviour.huntP(this, boids,bucketboids,wszystkie);
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
        double kat;
        Food target;
        vector2d jedziem=new vector2d(0,0);
        ArrayList<Food> seeFood=new ArrayList<Food>();

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
                  if(this.getPosition().getDistance(target.getPos())<=12)
                  {
                      mainBoids.simul.foraging_situation=true;
                     // jedziem.add(this.velocity);
                     // jedziem.multi(-14);
                      if(target.iam_eating()) jedzonko.remove(target);
                  }
                  else {
                      mainBoids.simul.foraging_situation=true;
                      jedziem.add(target.fpos);
                      jedziem.minus(this.getPosition());
                      jedziem.normalize();
                  }
               }
        }
        return jedziem;
    }
    //--------------------------------------------
    public void applyForce(double step) {
        velocity.add(acceleration.multi(step));
        if (velocity.getLength() > maxSpeed) {
            velocity.normalize();
            //---------------------------------
            if(this.type==2) velocity.multi(maxSpeed*0.8); // do przyspieszania drapieznika
            //---------------------------------
            else velocity.multi(maxSpeed);
            colorVelB=0;
        }else{
            colorVelB=1-(float)(velocity.getLength()/maxSpeed);
        }
    }

    public void move(double step) {
        vector2d temp = velocity.getVec();
        position.add(temp.multi(step));
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
        if (_accel.getLength() > maxForce) {
            _accel.normalize();
            _accel.multi(maxForce);
        colorAccelB=0;
        }
        this.acceleration = _accel;
    colorAccelB=1-(float)(_accel.getLength()/maxForce);
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
    public boolean czyOmijam(){
    return omijam;
    }
}
