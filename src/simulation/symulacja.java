package simulation;

import boids.Food;
import boids.boid;
import boids.mainBoids;
import static java.lang.StrictMath.abs;
import java.util.ArrayList;
import java.util.Random;
import math.vector2d;
import trunk.src.boids.Obstacle;

/**
 * @author Tomek
 */
public class symulacja {
  public ArrayList<boid> boids;
  ArrayList<Obstacle> obs;
  ArrayList<Food> food;
  public ArrayList<Obstacle> pom;
  public boolean continueSimulation;
  double cofSep,cofAli,cofCoh,leadCof,randCof,cofPred,cofAvoid,AvoidMode;
  int AvoidRec;
  double timeStep;
  int animSpeed;
  public double katWidzenia;
  public double radiusNeigh=64;
  double reactionTime;
  public vector2d globalAim=new vector2d(-1,-1);
  gridBucket siatkaKoszykow;
  //-----------------------------
  public boolean critical_sit,foraging_situation;
  //-----------------------------
  

  public symulacja(ArrayList<boid> _boids, ArrayList<Obstacle> _obs, ArrayList<Food> _food){
  cofSep=1;cofAli=1;cofCoh=1;randCof=1;
  continueSimulation=false;

  boids=_boids;
  obs=_obs;
  food=_food;
  animSpeed=10;
  reactionTime=50;
  siatkaKoszykow =new gridBucket(12,8,80,80,1100,700);
  pom=new ArrayList<Obstacle>();
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
 
  public ArrayList<boid> getNeighbourhoodOptm(boid osobnik){ // zmieniłem na public - Grzesiek
  ArrayList<boid> neigh=new ArrayList<>();
  neigh.ensureCapacity(1000);
  double alfa,d;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeight(osobnik);
  
  for(int i=0;i<gridBoids.size();i++){
      
      d=osobnik.getPosition().getSDistance(gridBoids.get(i).getPosition());     
      
      if (d<(radiusNeigh*radiusNeigh) && !osobnik.equals(gridBoids.get(i))){ 
         alfa=osobnik.calcAngle(gridBoids.get(i).getPosition());
          if((180-alfa)<katWidzenia*180/3.1415){
              neigh.add(gridBoids.get(i));continue;
            }
      }   
      if  (d<(15*15) && !osobnik.equals(gridBoids.get(i))){
       neigh.add(gridBoids.get(i));continue;//jezeli jest bardzo blisko to widzi go nawet za plecami
      }
      if(osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/10 && !osobnik.equals(gridBoids.get(i))){  neigh.add(gridBoids.get(i)); continue;}
  } 
  return neigh;
  }
  
  public ArrayList<boid> getNeighbourhoodOptmTopological(boid osobnik, int maxNeigh ){ // zmieniłem na public - Grzesiek
  ArrayList<boid> neigh=new ArrayList<>();
  neigh.ensureCapacity(1000);
  double alfa,d;
  int inxMax=0;
  double maxDist=0;//Double.MAX_VALUE;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeight(osobnik);
  ArrayList<Double> distannces=new ArrayList<>();
  for(int i=0;i<gridBoids.size();i++){
      d=osobnik.getPosition().getSDistance(gridBoids.get(i).getPosition());     
      
      if (d<(radiusNeigh*radiusNeigh) && !osobnik.equals(gridBoids.get(i))){ 
         alfa=osobnik.calcAngle(gridBoids.get(i).getPosition());
          if((180-alfa)<katWidzenia*180/3.1415){
              if (maxDist<d && neigh.size()<maxNeigh){maxDist=d;}
              if (maxDist<d && neigh.size()>=maxNeigh){if (gridBoids.get(i).getType()==1){continue;}}
              if (maxDist>d && neigh.size()>=maxNeigh){maxDist=d;}
              neigh.add(gridBoids.get(i));
              distannces.add(d);
              continue; 
            }
      }else{continue;}   
      if  (d<(osobnik.radius*osobnik.radius*1.2) && !osobnik.equals(gridBoids.get(i))){
       if (maxDist<d && neigh.size()<maxNeigh){maxDist=d;}
              if (maxDist<d && neigh.size()>=maxNeigh){if (gridBoids.get(i).getType()==1){continue;}}
              if (maxDist>d && neigh.size()>=maxNeigh){maxDist=d;}
              neigh.add(gridBoids.get(i));
              distannces.add(d);
              continue;
      }
      if(osobnik.getVelocity().getLength()<osobnik.getMaxSpeed()/10 && !osobnik.equals(gridBoids.get(i))){ 
              if (maxDist<d && neigh.size()<maxNeigh){maxDist=d;}
             if (maxDist<d && neigh.size()>=maxNeigh){if (gridBoids.get(i).getType()==1){continue;}}
              if (maxDist>d && neigh.size()>=maxNeigh){maxDist=d;}
              neigh.add(gridBoids.get(i));
              distannces.add(d);
              continue;
      }
  } 
 // System.out.println("d- "+maxDist);
  for(int i=0;i<neigh.size();i++){
  if (distannces.get(i)>maxDist && neigh.get(i).getType()==1){
  distannces.remove(i);
  neigh.remove(i);
  i--;
  }
  
  }mainBoids.stat.averageNumOfNeight+=neigh.size();
  return neigh;
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;
  }
  public void setReationTime(double _rectionTime){
  reactionTime=_rectionTime;
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof,double avCof){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;cofAvoid=avCof;
  }
  public void setParametrs(double aCof,double sCof,double cCof,double lCof,double pCof,double avCof, double AvMode){
      cofSep=sCof;cofAli=aCof;cofCoh=cCof;leadCof=lCof;cofPred=pCof;cofAvoid=avCof;AvoidMode=AvMode;
  }
  public void setRandCof(double rCof){
      randCof=rCof;
  }
  public void setAvoidRec(int rec){
      AvoidRec=rec;
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
      siatkaKoszykow.writeToGrid(boids);
      long start=System.nanoTime();
      long end;
      double time;
      double timeMin=0;
      double fps;
      vector2d sep,ali,coh,lead,rand,pred, avoid, predH,toAim,forag;
      ArrayList<boid> tempBoids;
      
      pom.addAll(obs);
      pom.addAll(food);
      
      while(continueSimulation){
      end=start;
      start=System.nanoTime();   
      //System.out.println(System.nanoTime());
      time=(start-end)/1000000d;
      timeMin+=time;
  // System.out.println("t"+time);
      while(time<reactionTime-1){
          try{
            Thread.sleep((int)(reactionTime-time));
            start=System.nanoTime();   
            time=(start-end)/1000000d;
      
          } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
          }
      }
      timeStep=((double)time)/(55-animSpeed);

       for(int i=0;i<boids.size();i++){ 
          if (boids.get(i).getType()==2){continue;}
          tempBoids=getNeighbourhoodOptmTopological(boids.get(i),mainBoids.mainWin.getNumNeight());
          // System.out.println(tempBoids.size());
          //if (tempBoids.size()>0){boids.get(i).radius=20;}
          sep= boids.get(i).separate(tempBoids);
          ali= boids.get(i).alignment(tempBoids);
          coh= boids.get(i).cohesion(tempBoids);
          lead= boids.get(i).followLeader(tempBoids);
          rand=new vector2d(randGen.nextDouble()*2-1,randGen.nextDouble()*2-1);
          avoid=boids.get(i).better_avoid(pom,AvoidMode, AvoidRec);
          toAim=boids.get(i).goToAim(globalAim);
          pred=boids.get(i).predator(tempBoids);
          forag=boids.get(i).foraging(food, katWidzenia);
          
          sep.multi(cofSep);
          ali.multi(cofAli);
          coh.multi(cofCoh);
          lead.multi(leadCof);
          rand.multi(randCof);
          pred.multi(cofPred);
          avoid.multi(cofAvoid);
           /* Dla drapieżnika wyłączony wektor losowy */
//           if(boids.get(i).getType()==2) rand=new vector2d(0,0);
          
           /**
            * rozbudowałem o sytuację wyjątkową jak flaga critical_situation jest ustawiona ma olewać wszystko oprócz wybranego wektora,
            * jest też flaga od żerowania, czyli olewka wszystkiego oprocz wektora zerowania, chyba ze krytyczna sytuacja
            */
           if(!critical_sit && !foraging_situation) boids.get(i).setAcceleration(((sep.add(ali)).add(coh)).add(lead).add(rand).add(pred).add(avoid).add(toAim).add(forag));
           else
           {
               if(foraging_situation && !critical_sit)
               {
                   boids.get(i).setAcceleration(forag.add(sep));
                   foraging_situation=false;
               }
               else {
                    if(mainBoids.mainWin.getEscapeStrategy()==0) boids.get(i).setAcceleration(coh.multi(1));
                    else boids.get(i).setAcceleration(pred);
               
                    critical_sit=false;
                    foraging_situation=false;
               }
           }
       }
       
       for(int i=0;i<mainBoids.predators.size();i++){
            tempBoids=getNeighbourhoodOptm(mainBoids.predators.get(i));
            predH=mainBoids.predators.get(i).predHunt(tempBoids,siatkaKoszykow.getArrayNeightB(mainBoids.predators.get(i)));
            vector2d Sep=mainBoids.predators.get(i).separatePredator(tempBoids);
            mainBoids.predators.get(i).setAcceleration(Sep.add(predH));
       }
             
       for(int i=0;i<boids.size();i++){
            boids.get(i).applyForce(timeStep);
            if (boids.get(i).czyBum()) {mainBoids.stat.incNumOfColision();}
            mainBoids.stat.averageSpeed.add(boids.get(i).getVelocity());
            mainBoids.stat.odstAverageSpeed+=mainBoids.stat.prevAverageSpeed.getVec().normalize().minus(boids.get(i).getVelocity().getVec().normalize()).getLength()/(2);
            boids.get(i).move(timeStep);
            siatkaKoszykow.updateGrid(boids.get(i));
       }
       
       fps=100000/time;    
       if (timeMin>333){
           timeMin=0;
           mainBoids.mainWin.setFPS((int)fps);
       }
       mainBoids.stat.updateStats();
       mainBoids.mainWin.ptr.repaint( );
      }
  }
}
