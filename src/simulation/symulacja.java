package simulation;

import boids.boid;
import boids.mainBoids;
import static java.lang.StrictMath.abs;
import java.util.ArrayList;
import java.util.Random;
import math.vector2d;

/**
 * @author Tomek
 */
public class symulacja {
  ArrayList<boid> boids;
  public boolean continueSimulation;
  double cofSep,cofAli,cofCoh,leadCof,randCof;
  double timeStep;
  int animSpeed;
  public double katWidzenia;
  public double radiusNeigh=64;
  public symulacja(){
   cofSep=1;cofAli=1;cofCoh=1;
   continueSimulation=false;
   timeStep=1;//pozniej zmienic
   animSpeed=10;
  }
  public symulacja(ArrayList<boid> _boids){
      cofSep=1;cofAli=1;cofCoh=1;randCof=1;
   continueSimulation=false;
    timeStep=1;//pozniej zmienic
  boids=_boids;
  animSpeed=10;
  }
  public void addBoid(boid agt){
      boids.add(agt);
  }
  public void changeAnimSpeed(int speed){
      animSpeed=speed;
  }
  private ArrayList<boid> getNeighbourhood(boid osobnik){
  ArrayList<boid> neigh=new ArrayList<boid>();
      double alfa=osobnik.calcAngle();
      double mian;
      double k2;
  for(int i=0;i<boids.size();i++){
      if ( osobnik.getPosition().getSDistance(boids.get(i))<(radiusNeigh*radiusNeigh) &&osobnik!=boids.get(i) ){
          if (osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/10){//jesli osobnik sie prawie nie porusza to ma oczy dookola glowy
              neigh.add(boids.get(i));
          }else{
             mian=(boids.get(i).getX()-osobnik.getX());
          if (mian==0){mian=0.0000000001;}
              k2=Math.atan((boids.get(i).getY()-osobnik.getY())/mian);
          if(abs(alfa-k2)<katWidzenia){neigh.add(boids.get(i));}
          }
      }
  }
  return neigh;//to tylko pogladowo narazie
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;
  }
  public void setRandCof(double rCof){
      randCof=rCof;
  }
  public void setNeightParametrs(double angle,double distance){
     katWidzenia=angle;
     radiusNeigh=distance;
  }
  public void setAnimSpeed(int speed){
      animSpeed=speed;
  }
  public void simulate(){
      continueSimulation=true;
      Random randGen = new Random();
    //  Calendar lCDateTime = Calendar.getInstance();
      long start=System.currentTimeMillis();
      long end;
      long time;
      vector2d sep,ali,coh,lead,rand;
      ArrayList<boid> tempBoids;
      while(continueSimulation){
      end=start;
      start=System.currentTimeMillis();   
      time=start-end;
     // System.out.println("t"+timeStep);
      if (time==0){
          try{
            Thread.sleep(1);
            continue;
          } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
          }
      }
      timeStep=((double)time)/(55-animSpeed);
       
       for(int i=0;i<boids.size();i++){
          tempBoids=getNeighbourhood(boids.get(i));
          sep= boids.get(i).spearate(tempBoids);
          ali= boids.get(i).alignment(tempBoids);
          coh= boids.get(i).cohesion(tempBoids);
          lead= boids.get(i).followLeader(tempBoids);
          rand=new vector2d(randGen.nextDouble()*2-1,randGen.nextDouble()*2-1);
          sep.multi(cofSep);
          ali.multi(cofAli);
          coh.multi(cofCoh);
          lead.multi(leadCof);
          rand.multi(randCof);
          boids.get(i).setAcceleration(((sep.add(ali)).add(coh)).add(lead).add(rand));
       }
       for(int i=0;i<boids.size();i++){
         boids.get(i).applyForce(timeStep);
         boids.get(i).move(timeStep);
       }
       double fps=0;
       if (time!=0){
       fps=100000/time;    
       }
       mainBoids.mainWin.setFPS((int)fps);
       mainBoids.mainWin.ptr.repaint( );
      }
  }
}
