package simulation;

/**
 * @author Tomek
 */

public class threadMove implements Runnable{
    public symulacja simul=null;
    int id;
    int max;
    public threadMove(symulacja _simul,int _id,int _max){
        simul=_simul;
        id=_id;
        max=_max;
    }
    @Override
    public void run() {
        if (id ==0){
            simul.simulateMove(0,simul.boids.size());
        }
        else{
            simul.simulateMove((simul.boids.size()*(id-1)/max),(simul.boids.size()*id/max));
            
        }
        
    }

}
