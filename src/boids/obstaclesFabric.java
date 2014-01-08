package trunk.src.boids;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Tomek
 */
public class obstaclesFabric {
    int numberOfObs;
    ArrayList<Obstacle> obs;
    public obstaclesFabric(int n){
        numberOfObs=n;
        obs=new ArrayList<Obstacle>(n);
    }
    
    public obstaclesFabric(){       
        obs=new ArrayList<Obstacle>();
    }
    
    public ArrayList<Obstacle> createObs(int n, int rad){
        Random randGen = new Random();
        int x=0,y=0;
        for(int i=0;i<n;i++){
            
            obs.add(new Obstacle(randGen.nextInt(1095-100)+20,randGen.nextInt(680-100)+50, rad));
            //obs.get(i).radius=40;
        }
        return obs;
    }
    
    public ArrayList<Obstacle> createObs(int n){
        Random randGen = new Random();
        int x=0,y=0;
        for(int i=0;i<n;i++){
            
            obs.add(new Obstacle(randGen.nextInt(1095-100)+20,randGen.nextInt(680-100)+50));
            //obs.get(i).radius=40;
        }
        return obs;
    }
    
}
