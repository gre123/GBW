package simulation;

import boids.mainBoids;
import java.io.File;
import java.io.FileOutputStream;
import math.vector2d;

/**
 * @author Tomek
 */
public class statistic {
    int numberOfBoids;
    int numberOfPredators;
    int numberOfLeaders;
    int numOfColision;
    vector2d averageSpeed,prevAverageSpeed;
    vector2d averageAcceleration;
    double averageNumOfNeight;
    double odstAverageSpeed;
    double averageDist;
    double performence,maxPerf,minPerf;
    boolean perfUstal;
    int collisions;
    int boidsHaveLeader;
    double [] perf;
    int iS,iE,sizePerf;
    File f;
    public statistic(int nBoids,int nPredators,int nLeaders){
    
    numberOfBoids=nBoids;
    numberOfPredators=nPredators;
    numberOfLeaders=nLeaders;
    averageSpeed=new vector2d(0,0);
    prevAverageSpeed=new vector2d(0,0);
    odstAverageSpeed=0;
    averageAcceleration=new vector2d(0,0);
    averageNumOfNeight=0;
    boidsHaveLeader=0;
    averageDist=0;
    performence=0;
    maxPerf=0;
    perfUstal=false;
    minPerf=Double.MAX_VALUE;
    collisions=0;
    sizePerf=100;
     perf= new double[sizePerf];
     iS=0;
     iE=1;  
    }
    public void updateStats(){
        numberOfBoids=mainBoids.boids.size();
        numberOfPredators=mainBoids.leaders.size();
        numberOfLeaders=mainBoids.predators.size();
        mainBoids.mainWin.setNumOfThings(numberOfBoids, numberOfPredators, numberOfLeaders);
        mainBoids.mainWin.setAvgNumNeight(averageNumOfNeight/numberOfBoids);averageNumOfNeight=0;
        mainBoids.mainWin.setHeveLeader((boidsHaveLeader*100)/numberOfBoids);boidsHaveLeader=0;
        mainBoids.mainWin.setNumOfColision(numOfColision);numOfColision=0;
        mainBoids.mainWin.setAvgSpeed(averageSpeed.getX()/numberOfBoids, averageSpeed.getY()/numberOfBoids);prevAverageSpeed=averageSpeed.getVec();averageSpeed.setX(0);averageSpeed.setY(0);
        mainBoids.mainWin.setAvgSpeedOdst((odstAverageSpeed*100)/numberOfBoids);odstAverageSpeed=0;
        mainBoids.mainWin.setAvgDist(averageDist/numberOfBoids);averageDist=0;
        mainBoids.mainWin.setPerformace(performence*1000/sizePerf);
        if (perfUstal==true){
        mainBoids.mainWin.setMaxPerf(maxPerf*1000);
        mainBoids.mainWin.setMinPerf(minPerf*1000);
        }
        mainBoids.mainWin.setNumCollisions(collisions);collisions=0;
    }
    public void incBoidHaveLeader(){
    boidsHaveLeader++;
    }
    public void incNumOfColision(){
    numOfColision++;
    }
    public void addAverageDist(double d){
    averageDist+=d;
    }
    public void incCollisonNumber(){
    collisions++;
    }
    public void addPerformance(double d){
     if(d>0.01){
         if (perfUstal==true){
         if(maxPerf<1/d){maxPerf=1/d;}
         if(minPerf>1/d){minPerf=1/d;}
         }
    performence+=1/d;
    performence-=perf[iE];
    perf[iS]=1/d;
    perf[iE]=0;

    if(iS<sizePerf-1){iS++;}
    else{iS=0;perfUstal=true;}
    if(iE<sizePerf-1){iE++;}
    else{iE=0;}
     }
    }
    
    public void saveStats()
    {
       if(f==null) f=new File(mainBoids.mainWin.fSource);
    }
}
