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
    vector2d averageSpeed;
    vector2d averageAcceleration;
    double averageNumOfNeight;
    int boidsHaveLeader;
    public statistic(int nBoids,int nPredators,int nLeaders){
    numberOfBoids=nBoids;
    numberOfPredators=nPredators;
    numberOfLeaders=nLeaders;
    averageSpeed=new vector2d(0,0);
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
        
    }
}
