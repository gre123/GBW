package boids;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.sqrt;
import java.util.ArrayList;
import java.util.Random;
import math.vector2d;

/**
 * @author Tomek
 */
public class boid {
    vector2d position;
    vector2d velocity;
    vector2d acceleration;//to moze niepotrzebne
    double angle;
    double radius;
    double maxSpeed;
    double maxForce;
    int type,eats;
    double katWidzenia;
    double minimalDistance;
    public boid(double  x,double y){
        Random randGen = new Random();
        acceleration=new vector2d(0,0);
        velocity=new vector2d(0,0);
        position=new vector2d(x,y);
        radius=7;
        maxSpeed=1;
        maxForce=0.5;
       // angle=randGen.nextDouble()*360;
        minimalDistance=15;
        type=1;
        eats=-1;
        katWidzenia=0.5;
        
    }
    public vector2d spearate(ArrayList<boid> boids){
    vector2d value=new vector2d(0,0);
    vector2d pos=new vector2d(0,0);
    int k=0;
    double sDist;
     if (type==3 || type==2 || type==0 ||boids.isEmpty()){return value;}
    for(int i=0;i<boids.size();i++){//poprawic getdistance do innej klasy ma byc
        sDist=this.position.getSDistance(boids.get(i));
       if (sDist<minimalDistance*minimalDistance){
           if (sDist==0){
           sDist=0.000000001;
            }
           k++;
           pos.setX(this.getX()-boids.get(i).getX());
           pos.setY(this.getY()-boids.get(i).getY());
           pos.div(sDist);
          value.add(pos);
       }
    }
    if (k>0){value.div(k);}
    else {return value;}
    return value.normalize();
    }
    public vector2d alignment(ArrayList<boid> boids){
    vector2d value=new vector2d(0,0);
    
    vector2d pos=new vector2d(0,0);
     if (type==3 || type==2 || boids.size()==0 || type==0){return value;}
    for(int i=0;i<boids.size();i++){
           pos.add(boids.get(i).velocity);
    }
    if (boids.size()!=0){
    pos.div(boids.size()).minus(this.velocity);//ten minus nie wiem co robi
    return pos.normalize();
    }else{return pos.normalize();}
    } 
    public vector2d followLeader(ArrayList<boid> boids){
    vector2d value=new vector2d(0,0);
    
    vector2d pos=new vector2d(0,0);
    double ratioDistance=0;
   // ArrayList<boid> leaders= new ArrayList<boid>();
   
    if (type==3 || type==2 || type==0 || boids.isEmpty()){
        return value;}
     boid leader=null;
    int k=0;double dist=1;
    double minDist=100000;
    for(int i=0;i<boids.size();i++){
       if (boids.get(i).type==0){
           //pos.add(boids.get(i).getPosition());
           dist=this.getPosition().getDistance(boids.get(i));
           if(dist<minDist){
           leader=boids.get(i);
           minDist=dist;
           }
       }
    }
    if (leader!=null){
    pos=leader.getPosition().getVec();
  //  pos.minus(leader.getVelocity().getVec().normalize().multi(50));
    value=pos.minus(this.position);
   
    if (dist>20){return value.div(dist).normalize();}
  //  else if (dist<20){return new vector2d(0,0);}
    else return value.normalize();
    
    }else{return value;}

   }
    
    //--------------------------------------------
    /**
     * Udaje zachowanie wobec drapieżnika
     * 
     * @param boids
     * @return 
     */
    public vector2d predator(ArrayList<boid> boids){
        vector2d wynik;
        wynik=PBehaviour.escapeP(this, boids);
      
        return wynik;
    }
     public vector2d predHunt(ArrayList<boid> pred,ArrayList<boid> boids,ArrayList<boid> wszystkie){
         vector2d wynik;
         wynik=PBehaviour.huntP(this, boids,pred,wszystkie);
         return wynik;
     }
    //--------------------------------------------
    
    public vector2d cohesion(ArrayList<boid> boids){
    vector2d value=new vector2d(0,0);
    vector2d pos=new vector2d(0,0);
    if (type==3 || type==2 || type==0 ||boids.size()==0){return value;}
    for(int i=0;i<boids.size();i++){
        pos.add(boids.get(i).position);
    }
    pos.div(boids.size());
    value=pos.minus(this.position);
    return value.normalize();
    }
    public void applyForce(double step){    
        velocity.add(acceleration.multi(step));
        if (velocity.getLength()>maxSpeed){
        velocity.normalize();
        velocity.multi(maxSpeed);
        }
    }
    public void move(double step){
        vector2d temp=velocity.getVec();
        position.add(temp.multi(step));
        //System.out.println(velocity.getLength());
        double maxX=1090;
        double maxY=675;
       // velocity.multi(0.1);
        if (position.getX()<0){position.setX(maxX+position.getX());}
        if (position.getX()>maxX){position.setX(0+position.getX()-maxX);}
        if (position.getY()<0){position.setY(maxY+position.getY());}
        if (position.getY()>maxY){position.setY(0+position.getY()-maxY);}
       
    }
    public double calcAngle(){
        double k1=0;
        if (velocity.getX()!=0){
        k1=Math.atan(velocity.getY()/velocity.getX());
        }else{Math.atan(velocity.getY()/0.0000000001);}
        return k1;
    }
    public vector2d getAcceleration(){
    return this.acceleration;
    }
    public void setAcceleration(vector2d _accel){
       if  (_accel.getLength()>maxForce){
       _accel.normalize();
       _accel.multi(maxForce);
       }
    this.acceleration=_accel;
    }
    public vector2d getPosition(){
    return this.position;
    }
    public vector2d getVelocity(){
    return this.velocity;
    }
    public double getMaxSpeed(){
    return this.maxSpeed;
    }
    public void setPosition(vector2d _pos){
    this.position=_pos;
    }
    public double getX(){
    return position.getX();
    }
    public double getY(){
    return position.getY();
    }
    public double getR(){
    return radius;
    }
    public int getType(){
    return type;
    }
}
