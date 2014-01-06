package boids;

import simulation.symulacja;
import gui.mainWindow;
import java.util.ArrayList;
import javax.swing.UIManager;
import math.trigonometric;
import trunk.src.boids.Obstacle;

/**
 * @author Bylina, Gajda, Wszołek
 */

public class mainBoids {
    
    public static mainWindow mainWin=null;
    public static ArrayList<boid> boids;
    public static ArrayList<boid> predators;
    public static ArrayList<boid> leaders;
    public static ArrayList<Food> food;
    public static ArrayList<Obstacle> obs;
    public static symulacja simul = null;
    public static trigonometric tryg;
	public static statistic stat=null;
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mainWin = new mainWindow();
        mainWin.setVisible(true);
        tryg = new trigonometric(20, 4000);
    }

}
