package simulation;

import java.util.logging.Level;
import java.util.logging.Logger;

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
