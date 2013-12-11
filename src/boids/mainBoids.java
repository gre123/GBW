package boids;

import simulation.symulacja;
import gui.mainWindow;
import java.util.ArrayList;
import math.trigonometric;

/**
 * @author Bylina, Gajda, Wszołek
 */

public class mainBoids {
    
    public static mainWindow mainWin=null;
    public static ArrayList<boid> boids;
    public static ArrayList<boid> prey;
    public static symulacja simul=null;
    public static trigonometric tryg;  
    public static void main(String[] args){
      
       mainWin=new mainWindow();
       mainWin.setVisible(true);
       tryg=new trigonometric(20,4000);   
    }
    
}
