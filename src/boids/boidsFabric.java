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
    double mass;
    double skala;
    double separateRadius=4;
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
    public void setBoidsParametrs(double _maxSpeed,double _maxAccel,double _mass,double _skala){
        maxSpeed=_maxSpeed*_skala;
        maxAccel=_maxAccel*_skala;
        mass=_mass;
        skala=_skala;
    }
    public ArrayList<boid> createBoids(int n,int np,double per){
        Random randGen = new Random();
        ArrayList<boid> pom=new ArrayList<boid>();
        int total=n+np+mainBoids.mainWin.getNumOfLeaders();
        int rozklad= mainBoids.mainWin.getRozklad();
        int leadMovement=mainBoids.mainWin.getLeaderTypeMovement();
        int x=0,y=0;
        int r;
        double wsp=(1080*680)/total;
        wsp=sqrt(wsp);
        boids.ensureCapacity(total+1);
        int boidRadius=mainBoids.mainWin.getBoidSize();
        int leaderRadius=mainBoids.mainWin.getLeaderSize();
        int predatorRadius=mainBoids.mainWin.getPredatorSize();
        double minimalDistSeparate=mainBoids.mainWin.getMinmalSeparate();
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
            boids.get(i).radius=boidRadius;
            boids.get(i).minimalDistance=minimalDistSeparate*skala;
            boids.get(i).masa=mass;
            boids.get(i).skala=skala;
            boids.get(i).separateRadius=separateRadius*skala;
            if (maxSpeed!=0){boids.get(i).maxSpeed=maxSpeed/1.2;}
            if (maxAccel!=0){ boids.get(i).maxForce=maxAccel; }
        }
        
        for(int i=0;i<mainBoids.mainWin.getNumOfLeaders();i++){
        boids.add(new boid(randGen.nextInt(1095),randGen.nextInt(680)));
        leaders.add(boids.get(boids.size()-1));
        boids.get(boids.size()-1).minimalDistance=minimalDistSeparate*skala;
        boids.get(boids.size()-1).type=0;
       // boids.get(boids.size()-1).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);
        boids.get(boids.size()-1).radius=leaderRadius;
        boids.get(boids.size()-1).aims= new ArrayList<>();
        boids.get(boids.size()-1).indexAims=0;
        boids.get(boids.size()-1).masa=mass;
         boids.get(boids.size()-1).skala=skala;
         boids.get(boids.size()-1).separateRadius=separateRadius*skala;
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
        boids.get(boids.size()-1).radius=predatorRadius;
        boids.get(boids.size()-1).minimalDistance=(predatorRadius+minimalDistSeparate)*skala;
        boids.get(boids.size()-1).masa=mass;
        boids.get(boids.size()-1).skala=skala;
        boids.get(boids.size()-1).separateRadius=separateRadius*skala;
        
            if (maxSpeed!=0){boids.get(boids.size()-1).maxSpeed=maxSpeed*0.9;}
            if (maxAccel!=0){boids.get(boids.size()-1).maxForce=maxAccel;}
        }
        //-------------------------------------------------
        /**
         * zmienia okresloną ilosc boidów na głodne
         */
        pom.addAll(leaders);
        pom.addAll(boids);
        for(int i=0;i<Math.round(per*pom.size());i++)
        {
            do
                r=randGen.nextInt(pom.size());
            while(pom.get(r).hungry);
            pom.get(r).hungry=true;
        }
        //-------------------------------------------------
        mainBoids.leaders=leaders;
        mainBoids.predators=predators;
        return boids;
    }
    /**
     * Dodaje lidera do imprezy, z tego co sprawdziłem nie trzeba go nigdzie dopisywać, return jest właściwie niepotrzebny
     * @param _x
     * @param _y
     * @return 
     */
    public boid crateLeader(double _x, double _y){
        boid lider = new boid(_x, _y);
        boids.add(lider);
        leaders.add(lider);
        lider.minimalDistance=mainBoids.mainWin.getMinmalSeparate();
        lider.type=0;
       // boids.get(boids.size()-1).velocity=new vector2d(randGen.nextInt(6)-3,randGen.nextInt(6)-3);
        lider.radius=mainBoids.mainWin.getLeaderSize();
        lider.aims= new ArrayList<>();
        lider.indexAims=0;
        int TypeMovement=mainBoids.mainWin.getLeaderTypeMovement();
        if (TypeMovement==0){
            lider.aims.add(new vector2d(340,150));
            lider.aims.add(new vector2d(270,330));
            lider.aims.add(new vector2d(340,520));
            lider.aims.add(new vector2d(530,590));
            lider.aims.add(new vector2d(710,510));
            lider.aims.add(new vector2d(780,340));
            lider.aims.add(new vector2d(710,160));
            lider.aims.add(new vector2d(530,80));
        }else if (TypeMovement==1){
            lider.aims.add(new vector2d(280,500));
            lider.aims.add(new vector2d(100,310));
            lider.aims.add(new vector2d(240,120));
            lider.aims.add(new vector2d(780,500));
            lider.aims.add(new vector2d(920,320));
            lider.aims.add(new vector2d(790,120));
        }else if (TypeMovement==2){
         lider.aims.add(new vector2d(60,60));
         lider.aims.add(new vector2d(1000,60));
         lider.aims.add(new vector2d(1000,600));
         lider.aims.add(new vector2d(60,600));
         
        }
        
            if (maxSpeed!=0){lider.maxSpeed=maxSpeed/1.2;}
            if (maxAccel!=0){lider.maxForce=maxAccel;}
        return lider;
        }
    /**
     * Dodaje drapieżnika, rezultatu nie trzeba nigdzie przypisywać.
     * @param _x
     * @param _y
     * @return 
     */
    public boid cratePredator(double _x, double _y){
        boid zjemcie = new boid(_x, _y);
        boids.add(zjemcie);
        predators.add(zjemcie);
        zjemcie.type=2;
        zjemcie.radius=mainBoids.mainWin.getPredatorSize();
        
            if (maxSpeed!=0){zjemcie.maxSpeed=maxSpeed;}
            if (maxAccel!=0){zjemcie.maxForce=maxAccel;}
        return zjemcie;
    }
}
