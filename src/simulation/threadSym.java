package simulation;

import static org.omg.IOP.CodecPackage.InvalidTypeForEncodingHelper.id;

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
