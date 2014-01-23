package simulation;

import boids.Food;
import boids.boid;
import boids.mainBoids;
import static java.lang.StrictMath.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import math.vector2d;
import boids.Obstacle;

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
  double skala;
  double reactionTime;
  public vector2d globalAim=new vector2d(-1,-1);
  public gridBucket siatkaKoszykow;
  //-----------------------------
  public boolean critical_sit,foraging_situation;
  //-----------------------------
  

  public symulacja(ArrayList<boid> _boids, ArrayList<Obstacle> _obs, ArrayList<Food> _food){
  cofSep=1;cofAli=1;cofCoh=1;randCof=1;
  continueSimulation=false;
  skala=10;
  boids=_boids;
  obs=_obs;
  food=_food;
  animSpeed=10;
  reactionTime=50;
  siatkaKoszykow =new gridBucket(21,13,mainBoids.panelSizeX,mainBoids.panelSizeY);
  pom=new ArrayList<>();
  }
  public void addBoid(boid agt){
      boids.add(agt);
  }
  public void changeAnimSpeed(int speed){
      animSpeed=speed;
  }
 
  public ArrayList<boid> getNeighbourhoodOptm(boid osobnik){
  ArrayList<boid> neigh=new ArrayList<>();
  neigh.ensureCapacity(300);
  double alfa,d;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeightCombinate(osobnik);
  
  for(int i=0;i<gridBoids.size();i++){
      
    d=osobnik.getPosition().getSDistance(osobnik.getBestPosition(gridBoids.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY));     
      if (d<radiusNeigh*radiusNeigh){ 
              neigh.add(gridBoids.get(i));
      }   
  } 
  return neigh;
  }
  
  public ArrayList<boid> getNeighbourhoodOptmTopological(boid osobnik, int maxNeigh ){ // zmieniłem na public - Grzesiek
  ArrayList<boid> neigh=new ArrayList<>();
  LinkedList<Double> distannces=new LinkedList<>();
  neigh.ensureCapacity(10);
 //distannces.ensureCapacity(10);
  double alfa,d,td;
  int inxMax=0;
  double maxDist=0;//Double.MAX_VALUE;
  ArrayList<boid> gridBoids=siatkaKoszykow.getArrayNeightCombinate(osobnik);
  osobnik.setHavePredator(false);
 // ArrayList<Double> distannces1=new ArrayList<>();
  int bucX=osobnik.getBucketX();
  int bucY=osobnik.getBucketY();
  int sizeX=mainBoids.panelSizeX;
  int sizeY=mainBoids.panelSizeY;
  int a=0,b=0,c=0;
  vector2d tempPosition;
  double difx,dify;
  for(int i=0;i<gridBoids.size();i++){
      difx=gridBoids.get(i).getBucketX()-bucX;
      dify=gridBoids.get(i).getBucketY()-bucY;
        tempPosition=gridBoids.get(i).getPosition().getVec();
     if (abs(difx)<=1){}
     else if (difx>2){tempPosition.add(-sizeX,0);}
     else if (difx<-2){tempPosition.add(sizeX,0);}
     if (abs(dify)<=1){}
     else if (dify>2){tempPosition.add(0,-sizeY);}
     else if (dify<-2){tempPosition.add(0,sizeY);}

      d=osobnik.getPosition().getSDistance(tempPosition);
      td=d;
      if (d<(radiusNeigh*radiusNeigh) && !osobnik.equals(gridBoids.get(i))){ 
         alfa=3.1415-osobnik.calcAngle(tempPosition);
         //System.out.println((3.1415-alfa)+"+"+katWidzenia);
         if (gridBoids.get(i).getType()==2){d=0; osobnik.setHavePredator(true);}
          if((alfa)<katWidzenia){
              d=d*((((alfa)/3.1415)+0.35)/1.35);
              if (maxDist<d && neigh.size()>=maxNeigh){}
              else if (maxDist>d && neigh.size()>=maxNeigh){
                  neigh.remove(inxMax);distannces.remove(inxMax); 
                  neigh.add(gridBoids.get(i));distannces.add(d);
                  maxDist=Collections.max(distannces);inxMax=distannces.indexOf(maxDist);
              continue;
              }else if (neigh.size()<maxNeigh){
                  if (maxDist<d){maxDist=d;inxMax=neigh.size();}
                  neigh.add(gridBoids.get(i));
                  distannces.add(d);
                  continue;
              }

            }
      }else{continue;}   
      if  (td<(osobnik.getMinimalDist()*osobnik.getMinimalDist())){
        //  d=d/10;
      if (maxDist<d && neigh.size()>=maxNeigh){}
              else if (maxDist>d && neigh.size()>=maxNeigh){
                  neigh.remove(inxMax);distannces.remove(inxMax); 
                  neigh.add(gridBoids.get(i));distannces.add(d);
                  maxDist=Collections.max(distannces);
                  inxMax=distannces.indexOf(maxDist);
              }else if (neigh.size()<maxNeigh){
                  if (maxDist<d){maxDist=d;inxMax=neigh.size();}
                  neigh.add(gridBoids.get(i));
                  distannces.add(d);
              }
      }
  } 

  mainBoids.stat.averageNumOfNeight+=neigh.size();
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
  public void setSkala(double _skala){
  skala=_skala;
  }
  public void setMass(double m){
 // masa=
  }
  public void setRandCof(double rCof){
      randCof=rCof;
  }
  public void setAvoidRec(int rec){
      AvoidRec=rec;
  }
  public void setNeightParametrs(double angle,double distance){
     katWidzenia=angle;
     radiusNeigh=distance*skala;
  }
  public void setAnimSpeed(int speed){
      animSpeed=speed;
  }
  public void simulate(){
      continueSimulation=true;
      Random randGen = new Random();
      siatkaKoszykow.writeToGrid(boids);
      long start;
      long end;
      double time;
      double timeMin=0;
      double fps;
      vector2d sep,ali,coh,lead,rand,pred, avoid, predH,toAim,forag;
      ArrayList<boid> tempBoids;
      
      pom.addAll(obs);
      pom.addAll(food);
      start=System.nanoTime();
      while(continueSimulation){
        
      end=start;
      start=System.nanoTime();  
      //System.out.println(System.nanoTime());
      time=(start-end)/1000000d;
      mainBoids.stat.addPerformance(time);
      if (mainBoids.mainWin.czyConstCzas()!=true){
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
      }else{time=reactionTime;}
     // timeStep=((double)time)/(55-animSpeed)/1000;
      timeStep=((double)time)/1000;

       for(int i=0;i<boids.size();i++){ 
          if (boids.get(i).getType()==2){continue;}
          tempBoids=getNeighbourhoodOptmTopological(boids.get(i),mainBoids.mainWin.getNumNeight());
          
          sep= boids.get(i).separate(tempBoids).multi(cofSep);
          if(sep.getSLength()<cofSep*cofSep){
          ali= boids.get(i).alignment(tempBoids).multi(cofAli);
          coh= boids.get(i).cohesion(tempBoids).multi(cofCoh);
          }else{ali=new vector2d(0,0);coh=new vector2d(0,0);}
          lead= boids.get(i).followLeader(tempBoids);
          toAim=boids.get(i).goToAim(globalAim).multi((cofAli+cofCoh)/1.5);
          rand=new vector2d(randGen.nextDouble()*2-1,randGen.nextDouble()*2-1);
          avoid=boids.get(i).better_avoid(pom,AvoidMode, AvoidRec);
          
          pred=boids.get(i).predator(tempBoids);
          forag=boids.get(i).foraging(food, katWidzenia);
          
          lead.multi(leadCof);
          rand.multi(randCof);
          pred.multi(cofPred);
          avoid.multi(cofAvoid);
          
           /**
            * rozbudowałem o sytuację wyjątkową jak flaga critical_sit jest ustawiona ma olewać wszystko oprócz wybranego wektora,
            * jest też flaga od żerowania, czyli olewka wszystkiego oprocz wybranych wektorów, chyba ze krytyczna sytuacja
            */
           if(!critical_sit && !foraging_situation){ boids.get(i).setAcceleration(((sep.add(ali)).add(coh)).add(lead).add(rand).add(pred).add(avoid).add(toAim).add(forag).multi(skala));}
           else
           {
               if(foraging_situation && !critical_sit)
               {
                   boids.get(i).setAcceleration(forag.add(sep).multi(skala));
                   foraging_situation=false;
               }
               else {
                    boids.get(i).setAcceleration(pred.multi(skala));
                    critical_sit=false;
                    foraging_situation=false;
               }
           }
       }
       
       for(int i=0;i<mainBoids.predators.size();i++){
            tempBoids=getNeighbourhoodOptmTopological(mainBoids.predators.get(i),30);
            predH=mainBoids.predators.get(i).predHunt(tempBoids,siatkaKoszykow.getArrayNeightB(mainBoids.predators.get(i)));
            vector2d Sep=mainBoids.predators.get(i).separatePredator(tempBoids);
            avoid=mainBoids.predators.get(i).better_avoid(pom,AvoidMode, AvoidRec);
            mainBoids.predators.get(i).setAcceleration(Sep.add(predH).add(avoid).multi(skala));
       }
             mainBoids.stat.prevAverageSpeed.normalize();
             float tmpColor;
       for(int i=0;i<boids.size();i++){
           tmpColor=(float)((mainBoids.stat.prevAverageSpeed.skalarny(boids.get(i).getVelocity().getVec().normalize()))-1)/(-2);
            boids.get(i).setColorOdstVelH(tmpColor);
            mainBoids.stat.odstAverageSpeed+=tmpColor;
            boids.get(i).applyForce(timeStep);
            if (boids.get(i).czyBum()) {mainBoids.stat.incNumOfColision();}
            mainBoids.stat.averageSpeed.add(boids.get(i).getVelocity());     
            boids.get(i).move(timeStep);
            siatkaKoszykow.updateGrid(boids.get(i));
       }
       
//       fps=100000/time;    
//       if (timeMin>333){
//           timeMin=0;
//           mainBoids.mainWin.setFPS((int)fps);
//       }
     mainBoids.stat.updateStats();
       mainBoids.mainWin.ptr.repaint( );
      }
  }
}
