/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package math;

import boids.boid;
import java.util.ArrayList;

/**
 *
 * @author Grzesiek
 */
public class Boidcounter {
    
    public static int count(double x, double y, int xsize, int ysize, ArrayList<boid> b)
    {
        int cnt=0;
        double x2=x+xsize;
        double y2=y+ysize;
        for(int i=0;i<b.size();i++) 
            if((b.get(i).getPosition().getX()>x)&&(b.get(i).getPosition().getX()<x2)&&(b.get(i).getPosition().getY()>y)&&(b.get(i).getPosition().getY()<y2)) cnt++;
        
        return cnt;
    }
}
