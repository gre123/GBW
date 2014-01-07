package simulation;

import boids.mainBoids;
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
    int boidsHaveLeader;
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
    }
    public void incBoidHaveLeader(){
    boidsHaveLeader++;
    }
    public void incNumOfColision(){
    numOfColision++;
    }
}
