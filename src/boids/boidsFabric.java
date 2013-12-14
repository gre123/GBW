package boids;

import static java.lang.Math.sqrt;
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
        int total=n+np+mainBoids.mainWin.getNumOfLeaders();
        int rozklad= mainBoids.mainWin.getRozklad();
        int x=0,y=0;
        double wsp=(1080*680)/total;
        wsp=sqrt(wsp);
        for(int i=0;i<n;i++){
            
            if(rozklad==0){ boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
            }else{
            boids.add(new boid(x*wsp,y*wsp));x++;
            if(x*wsp>1080){x=0;y++;}
            }
            boids.get(i).radius=5;
            if (maxSpeed!=0){boids.get(i).maxSpeed=maxSpeed;}
            if (maxAccel!=0){ boids.get(i).maxForce=maxAccel; }
        }
        
        for(int i=0;i<mainBoids.mainWin.getNumOfLeaders();i++){
        boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
        boids.get(boids.size()-1).type=0;
       // boids.get(boids.size()-1).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);
        boids.get(boids.size()-1).radius=7;
        boids.get(boids.size()-1).aim= new vector2d(1000,500);
            if (maxSpeed!=0){boids.get(boids.size()-1).maxSpeed=maxSpeed;}
            if (maxAccel!=0){boids.get(boids.size()-1).maxForce=maxAccel;}
        }
        
        //--------------------------------------
     
       for(int j=0;j<np;j++)
       {
         boids.get(j).type=2;
         boids.get(j).radius=12;
         boids.get(j).velocity=new vector2d(randGen.nextInt(9)-6,randGen.nextInt(9)-6);
       }
        //---------------------------------------
        return boids;
    }
    
}
