package simulation;

import boids.boid;
import boids.mainBoids;
import static java.lang.StrictMath.abs;
import java.util.ArrayList;
import java.util.Random;
import math.trigonometric;
import math.vector2d;
import trunk.src.boids.Obstacle;

/**
 * @author Tomek
 */
public class symulacja {
  ArrayList<boid> boids;
  ArrayList<Obstacle> obs;
  public boolean continueSimulation;
  double cofSep,cofAli,cofCoh,leadCof,randCof,cofPred,cofAvoid;
  double timeStep;
  int animSpeed;
  public double katWidzenia;
  public double radiusNeigh=64;
  public vector2d globalAim=new vector2d(-1,-1);
  gridBucket siatkaKoszykow;
  
  public symulacja(ArrayList<boid> _boids){
      cofSep=1;cofAli=1;cofCoh=1;randCof=1;
   continueSimulation=false;
    timeStep=1;//pozniej zmienic
  boids=_boids;
  animSpeed=10;
  siatkaKoszykow =new gridBucket(12,8,80,80,1100,700);
  }
  public symulacja(ArrayList<boid> _boids, ArrayList<Obstacle> _obs ){
      cofSep=1;cofAli=1;cofCoh=1;randCof=1;
   continueSimulation=false;
    timeStep=1;//pozniej zmienic
  boids=_boids;
  obs=_obs;
  animSpeed=10;
  siatkaKoszykow =new gridBucket(12,8,80,80,1100,700);
  }
  public void addBoid(boid agt){
      boids.add(agt);
  }
  public void changeAnimSpeed(int speed){
      animSpeed=speed;
  }
  private ArrayList<boid> getNeighbourhood(boid osobnik){
  ArrayList<boid> neigh=new ArrayList<>();
      double alfa=osobnik.calcAngle();
      double mian;
      double k2,d;

  for(int i=0;i<boids.size();i++){
      d=osobnik.getPosition().getSDistance(boids.get(i));
      if  (d<(18*18) &&osobnik!=boids.get(i) ){
       neigh.add(boids.get(i));continue;//jezeli jest bardzo blisko to widzi go nawet za plecami
      }
      if ( d<(radiusNeigh*radiusNeigh) &&osobnik!=boids.get(i) ){
          if (osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/5){//jesli osobnik sie prawie nie porusza to ma oczy dookola glowy
              neigh.add(boids.get(i));
          }else{
             mian=(boids.get(i).getX()-osobnik.getX());
          if (mian==0){mian=0.0000000001;}
              k2=Math.atan2((boids.get(i).getY()-osobnik.getY()),mian);
          if(abs(alfa-k2)<katWidzenia){neigh.add(boids.get(i));}
          }
      }
  }
  return neigh;//to tylko pogladowo narazie
  }
  private ArrayList<boid> getNeighbourhoodOptm(boid osobnik){
  ArrayList<boid> neigh=new ArrayList<>();
  neigh.ensureCapacity(1000);
  double alfa,d;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeight(osobnik);
  
  for(int i=0;i<gridBoids.size();i++){
      d=osobnik.getPosition().getSDistance(gridBoids.get(i).getPosition());
      if  (d<(18*18) && !osobnik.equals(gridBoids.get(i))){
       neigh.add(gridBoids.get(i));continue;//jezeli jest bardzo blisko to widzi go nawet za plecami
      }
      if(osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/10 && !osobnik.equals(gridBoids.get(i))){  neigh.add(gridBoids.get(i)); continue;}
      if (d<(radiusNeigh*radiusNeigh) && !osobnik.equals(gridBoids.get(i))){ 
         alfa=osobnik.calcAngle(gridBoids.get(i).getPosition());
          if((180-alfa)<katWidzenia*180/3.1415){
              neigh.add(gridBoids.get(i));
            }
      }         
  } 
  return neigh;
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof,double avCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;cofAvoid=avCof;
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
     // siatkaKoszykow.writeToGrid(boids);
      long start=System.nanoTime();
      
      long end;
      double time;
      double timeMin=0;
       double fps;
      vector2d sep,ali,coh,lead,rand,pred, avoid, predH,toAim;
      
      ArrayList<boid> tempBoids;
      while(continueSimulation){
      end=start;
      start=System.nanoTime();   
      //System.out.println(System.nanoTime());
      time=(start-end)/1000000d;
      timeMin+=time;
     // System.out.println("t"+timeStep);

      timeStep=((double)time)/(55-animSpeed);
       
       for(int i=0;i<boids.size();i++){
           
          tempBoids=getNeighbourhoodOptm(boids.get(i));
          //if (tempBoids.size()>0){boids.get(i).radius=20;}
          sep= boids.get(i).spearate(tempBoids);
          ali= boids.get(i).alignment(tempBoids);
          coh= boids.get(i).cohesion(tempBoids);
          lead= boids.get(i).followLeader(tempBoids);
          rand=new vector2d(randGen.nextDouble()*2-1,randGen.nextDouble()*2-1);
          pred=boids.get(i).predator(tempBoids);
          predH=boids.get(i).predHunt(tempBoids,siatkaKoszykow.getArrayNeightB(boids.get(i)),boids);
          avoid = boids.get(i).avoid(obs);
         // System.out.println(avoid.getLength());
          //if (avoid.getLength()>0){rand=lead=coh=ali=new vector2d(0,0);}
          toAim=boids.get(i).goToAim(globalAim);
          sep.multi(cofSep);
          ali.multi(cofAli);
          coh.multi(cofCoh);
          lead.multi(leadCof);
          rand.multi(randCof);
          pred.multi(cofPred);
          avoid.multi(cofAvoid);
//          if (lead.getLength()>0){
//          System.out.println("s"+sep.getLength()+"c"+coh.getLength()+"l"+lead.getLength()+"a"+ali.getLength());
//          }
           if(boids.get(i).getType()==2) rand=new vector2d(0,0);
          
            boids.get(i).setAcceleration(((sep.add(ali)).add(coh)).add(lead).add(rand).add(pred).add(avoid).add(toAim).add(predH));
       }
       
       for(int i=0;i<boids.size();i++){
            boids.get(i).applyForce(timeStep);
            boids.get(i).move(timeStep);
            siatkaKoszykow.updateGrid(boids.get(i));
       }
       
       fps=100000/time;    
       if (timeMin>333){
           timeMin=0;
       mainBoids.mainWin.setFPS((int)fps);
       }
       mainBoids.mainWin.ptr.repaint( );
     //  System.out.println(prey.size());
      }
  }
}
