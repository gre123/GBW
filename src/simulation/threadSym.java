package simulation;

/**
 * @author Tomek
 */
public class threadSym implements Runnable{
    public symulacja simul=null;
    
    public threadSym(symulacja _simul){
    simul=_simul;
    }
    @Override
    public void run() {
            simul.simulate();
    }

}
