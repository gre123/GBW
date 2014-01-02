/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boids;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import math.vector2d;
import trunk.src.boids.Obstacle;

/**
 *
 * @author Grzesiek
 */
public class Food extends Obstacle{
    int x,y;
    int time;
    Random randGen;
    vector2d fpos;
    public ArrayList<Ellipse2D> cir=new ArrayList<Ellipse2D>();
    public Food(int iks, int igrek,int tFood)
    {
        super(iks,igrek);
        randGen=new Random();
        x=iks;
        y=igrek;
        fpos=new vector2d(x,y);
        time=tFood;
        for(int j=0;j<8;j++) 
                    cir.add(new Ellipse2D.Double(this.x+randGen.nextInt(16)-8,this.y+randGen.nextInt(16)-8,8,8));
        
    }
    public boolean iam_eating()
    {
        time--;
        if(time==-1) return true;
        return false;
    }
  
    public vector2d getPos()
    {
        return fpos;
    }
/**    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    } **/
}
