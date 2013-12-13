package boids;

import java.util.ArrayList;
import java.util.Random;
import math.vector2d;

/**
 * @author Tomek
 */
public class boidsFabric {
    int numberOfBoids;
    double maxSpeed=0;
    double maxAccel=0;
    ArrayList<boid> boids;
    public boidsFabric(int n){
        numberOfBoids=n;
        boids=new ArrayList<boid>(n);
    }
    public boidsFabric(){       
        boids=new ArrayList<boid>();
    }
    public void setBoidsParametrs(double _maxSpeed,double _maxAccel){
        maxSpeed=_maxSpeed;
        maxAccel=_maxAccel;
    }
    
    public ArrayList<boid> createBoids(int n,int np){
        Random randGen = new Random();
        for(int i=0;i<n;i++){
            boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
            if (randGen.nextFloat()<0.01){boids.get(i).type=0;boids.get(i).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);boids.get(i).radius=10;}
            if (maxSpeed!=0){
            boids.get(i).maxSpeed=maxSpeed;
            }
            if (maxAccel!=0){
            boids.get(i).maxForce=maxAccel; 
            }
        }
        
        //--------------------------------------
     
       for(int j=0;j<np;j++)
       {
         boids.get(j).type=2;
         boids.get(j).radius=15;
         boids.get(j).velocity=new vector2d(randGen.nextInt(9)-6,randGen.nextInt(9)-6);
       }
        //---------------------------------------
        return boids;
    }
    
}
