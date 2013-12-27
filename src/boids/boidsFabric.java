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
    ArrayList<boid> predators;
    ArrayList<boid> leaders;
    public boidsFabric(int n){
        numberOfBoids=n;
        boids=new ArrayList<>(n);
        predators=new ArrayList<>();
        leaders=new ArrayList<>();
    }
    public boidsFabric(){       
        boids=new ArrayList<>();
        predators=new ArrayList<>();
        leaders=new ArrayList<>();
    }
    public void setBoidsParametrs(double _maxSpeed,double _maxAccel){
        maxSpeed=_maxSpeed;
        maxAccel=_maxAccel;
    }
    
    public ArrayList<boid> createBoids(int n,int np){
        Random randGen = new Random();
        int total=n+np+mainBoids.mainWin.getNumOfLeaders();
        int rozklad= mainBoids.mainWin.getRozklad();
        int leadMovement=mainBoids.mainWin.getLeaderTypeMovement();
        int x=0,y=0;
        double wsp=(1080*680)/total;
        wsp=sqrt(wsp);
        boids.ensureCapacity(total+1);
        for(int i=0;i<n;i++){           
            if(rozklad==0){ boids.add(new boid(randGen.nextInt(1080),randGen.nextInt(680)));
            }else if(rozklad==1){
            boids.add(new boid(x*wsp,y*wsp));x++;
            if(x*wsp>1080){x=0;y++;}
            }else if(rozklad==2){
                x=(int)(randGen.nextGaussian()*150+540);
                while (x<0|| x>1080){x=(int)(randGen.nextGaussian()*150+540);}
                y=(int)(randGen.nextGaussian()*94+330);
                while (y<0|| y>680){y=(int)(randGen.nextGaussian()*90+330);}
            boids.add(new boid(x,y));
            }
            boids.get(i).radius=5;
            if (maxSpeed!=0){boids.get(i).maxSpeed=maxSpeed;}
            if (maxAccel!=0){ boids.get(i).maxForce=maxAccel; }
        }
        
        for(int i=0;i<mainBoids.mainWin.getNumOfLeaders();i++){
        boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
        leaders.add(boids.get(boids.size()-1));
        boids.get(boids.size()-1).type=0;
       // boids.get(boids.size()-1).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);
        boids.get(boids.size()-1).radius=7;
        boids.get(boids.size()-1).aims= new ArrayList<>();
        boids.get(boids.size()-1).indexAims=0;
     
        if (leadMovement==0){
            boids.get(boids.size()-1).aims.add(new vector2d(340,150));
            boids.get(boids.size()-1).aims.add(new vector2d(270,330));
            boids.get(boids.size()-1).aims.add(new vector2d(340,520));
            boids.get(boids.size()-1).aims.add(new vector2d(530,590));
            boids.get(boids.size()-1).aims.add(new vector2d(710,510));
            boids.get(boids.size()-1).aims.add(new vector2d(780,340));
            boids.get(boids.size()-1).aims.add(new vector2d(710,160));
            boids.get(boids.size()-1).aims.add(new vector2d(530,80));
        }else if (leadMovement==1){
            boids.get(boids.size()-1).aims.add(new vector2d(280,500));
            boids.get(boids.size()-1).aims.add(new vector2d(100,310));
            boids.get(boids.size()-1).aims.add(new vector2d(240,120));
            boids.get(boids.size()-1).aims.add(new vector2d(780,500));
            boids.get(boids.size()-1).aims.add(new vector2d(920,320));
            boids.get(boids.size()-1).aims.add(new vector2d(790,120));
        }else if (leadMovement==2){
         boids.get(boids.size()-1).aims.add(new vector2d(60,60));
         boids.get(boids.size()-1).aims.add(new vector2d(1000,60));
         boids.get(boids.size()-1).aims.add(new vector2d(1000,600));
         boids.get(boids.size()-1).aims.add(new vector2d(60,600));
         
        }
        
            if (maxSpeed!=0){boids.get(boids.size()-1).maxSpeed=maxSpeed;}
            if (maxAccel!=0){boids.get(boids.size()-1).maxForce=maxAccel;}
        }
        
        
        for(int i=0;i<np;i++){
        boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
        predators.add(boids.get(boids.size()-1));
        boids.get(boids.size()-1).type=2;
       // boids.get(boids.size()-1).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);
        boids.get(boids.size()-1).radius=9;
        
            if (maxSpeed!=0){boids.get(boids.size()-1).maxSpeed=maxSpeed;}
            if (maxAccel!=0){boids.get(boids.size()-1).maxForce=maxAccel;}
        }
        
        mainBoids.leaders=leaders;
        mainBoids.predators=predators;
        return boids;
    }
    
}
