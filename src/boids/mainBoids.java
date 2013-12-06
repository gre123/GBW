package boids;

import simulation.symulacja;
import gui.mainWindow;
import java.util.ArrayList;

/**
 * @author Bylina, Gajda, Wszołek
 */

public class mainBoids {
    
    public static mainWindow mainWin=null;
    public static ArrayList<boid> boids;
    public static symulacja simul=null;
    public static void main(String[] args){
       
       mainWin=new mainWindow();
       mainWin.setVisible(true);     
    }
    
}
