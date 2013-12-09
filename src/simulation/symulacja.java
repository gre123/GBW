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
  ArrayList<boid> boids,prey;
  public boolean continueSimulation;
  double cofSep,cofAli,cofCoh,leadCof,randCof,cofPred;
  double timeStep;
  int animSpeed;
  public double katWidzenia;
  public double radiusNeigh=64;
  gridBucket siatkaKoszykow;
  public symulacja(){
   cofSep=1;cofAli=1;cofCoh=1;
   continueSimulation=false;
   timeStep=1;//pozniej zmienic
   animSpeed=10;
  }
  public symulacja(ArrayList<boid> _boids, ArrayList<boid> _prey ){
      cofSep=1;cofAli=1;cofCoh=1;randCof=1;
   continueSimulation=false;
    timeStep=1;//pozniej zmienic
  boids=_boids;
  prey=_prey;
  animSpeed=10;
  siatkaKoszykow =new gridBucket(12,8,100,100,1100,700);
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
 // ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeight(osobnik);
     // System.out.println("size"+neigh.size());
  for(int i=0;i<boids.size();i++){
      if  (osobnik.getPosition().getSDistance(boids.get(i))<(18*18) &&osobnik!=boids.get(i) ){
       neigh.add(boids.get(i));continue;//jezeli jest bardzo blisko to widzi go nawet za plecami
      }
      if ( osobnik.getPosition().getSDistance(boids.get(i))<(radiusNeigh*radiusNeigh) &&osobnik!=boids.get(i) ){
          if (osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/5){//jesli osobnik sie prawie nie porusza to ma oczy dookola glowy
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
  private ArrayList<boid> getNeighbourhoodOptm(boid osobnik){
  ArrayList<boid> neigh=new ArrayList<boid>();
      double alfa=osobnik.calcAngle();
      double mian;
      double k2;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeight(osobnik);
  
  for(int i=0;i<gridBoids.size();i++){
      if  (osobnik.getPosition().getSDistance(gridBoids.get(i))<(18*18) &&osobnik!=gridBoids.get(i) ){
       neigh.add(gridBoids.get(i));continue;//jezeli jest bardzo blisko to widzi go nawet za plecami
      }
      if ( osobnik.getPosition().getSDistance(gridBoids.get(i))<(radiusNeigh*radiusNeigh) &&osobnik!=gridBoids.get(i) ){
          if (osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/5){//jesli osobnik sie prawie nie porusza to ma oczy dookola glowy
              neigh.add(gridBoids.get(i));
          }else{
             mian=(gridBoids.get(i).getX()-osobnik.getX());
          if (mian==0){mian=0.0000000001;}
              k2=Math.atan((gridBoids.get(i).getY()-osobnik.getY())/mian);
          if(abs(alfa-k2)<katWidzenia){neigh.add(gridBoids.get(i));}
          }
      }
  }
  return neigh;//to tylko pogladowo narazie
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;
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
      
      long start=System.currentTimeMillis();
      long end;
      long time;
      long timeMin=0;
       double fps=0;
      vector2d sep,ali,coh,lead,rand,pred,predH;
      
      ArrayList<boid> tempBoids;
      while(continueSimulation){
      end=start;
      start=System.currentTimeMillis();   
      time=start-end;
      timeMin+=time;
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
           
          tempBoids=getNeighbourhoodOptm(boids.get(i));
          
          sep= boids.get(i).spearate(tempBoids);
          ali= boids.get(i).alignment(tempBoids);
          coh= boids.get(i).cohesion(tempBoids);
          //lead= boids.get(i).followLeader(boids);//to ladnie wyglada ale chyba nie jest poprawne
          lead= boids.get(i).followLeader(tempBoids);
          rand=new vector2d(randGen.nextDouble()*2-1,randGen.nextDouble()*2-1);
          pred=boids.get(i).predator(tempBoids);
          predH=boids.get(i).predHunt(prey,tempBoids,boids);
          sep.multi(cofSep);
          ali.multi(cofAli);
          coh.multi(cofCoh);
          lead.multi(leadCof);
          rand.multi(randCof);
          pred.multi(cofPred);
//          if (lead.getLength()>0){
//          System.out.println("s"+sep.getLength()+"c"+coh.getLength()+"l"+lead.getLength()+"a"+ali.getLength());
//          }
           if(boids.get(i).getType()!=2) rand=new vector2d(0,0);
          
            boids.get(i).setAcceleration(((sep.add(ali)).add(coh)).add(lead).add(rand).add(pred));
       }
       
       for(int i=0;i<boids.size();i++){
            boids.get(i).applyForce(timeStep);
            boids.get(i).move(timeStep);
            siatkaKoszykow.updateGrid(boids.get(i));
       }
      
       
       fps=100000/time;    
       if (timeMin>500){
           timeMin=0;
       mainBoids.mainWin.setFPS((int)fps);
       }
       mainBoids.mainWin.ptr.repaint( );
     //  System.out.println(prey.size());
      }
  }
}
