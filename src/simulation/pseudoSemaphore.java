package simulation;

/**
 * @author Tomek
 */
public class pseudoSemaphore {
    public int level;
    public int maxLevel;
    public final Object locker;
    public pseudoSemaphore(int _maxLevel,Object _locker){
    level=maxLevel=_maxLevel;     
    locker=_locker;
    }
    public synchronized void decSemaphore(){
    level--;
    }
    
    public synchronized boolean isZero(){
    return level==0;
    }
    public void resetSemaphore(){
    level=maxLevel;
    }
    public void notifyLocker(){
        synchronized(locker){
          locker.notify();
        }
    }
}
