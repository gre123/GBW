package simulation;

/**
 * @author Tomek
 */

public class threadPart implements Runnable{
    public symulacja simul=null;
    int id;
    int max;
    public threadPart(symulacja _simul,int _id,int _max){
        simul=_simul;
        id=_id;
        max=_max;
    }
    @Override
    public void run() {
        if (id ==0){
            simul.simulatePart(0,simul.boids.size());
        }
        else{
            simul.simulatePart((simul.boids.size()*(id-1)/max),(simul.boids.size()*id/max));
            
        }
        
    }

}
