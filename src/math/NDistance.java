/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package math;

import boids.Food;
import boids.boid;
import java.util.ArrayList;

/**
 *
 * @author Grzesiek
 */
public class NDistance {
    
    public static Food minFood(boid ten,ArrayList<Food> w)
    {
        double d=Double.MAX_VALUE;
        Food min=null;
        double tempDist;
        for(int i=0;i<w.size();i++)
        {
            tempDist=ten.getPosition().getSDistance(w.get(i).getPos());
            if(d>tempDist)
            {
                min=w.get(i);
                d=tempDist;
            }
        }
        return min;
    }
    
    public static boid minPrey(boid ten,ArrayList<boid> boids,double distance)
    {
       //double preyDistance=14;
        double pom;
        boid k=null;
        double d=distance; //to zmienić?
        for(int j=0;j<boids.size();j++)
        {
            pom=ten.getPosition().getSDistance(boids.get(j));
            if(d>pom && boids.get(j).getType()!=2) 
            {
                d=pom; 
                k=boids.get(j);
            }
        }
       // if (k==null) return k;
       // if(pom<=distance) return k;
       // else return null;
        return k;
    }
    
    public static boid minDist(boid ten,ArrayList<boid> boids)
    {
        double pom=0;
        boid k=null;
        double d=Double.MAX_VALUE; //to zmienić?
        for(int j=0;j<boids.size();j++)
        {
            pom=ten.getPosition().getSDistance(boids.get(j));
            if(d>pom && boids.get(j).getType()!=2) 
            {
                d=pom; 
                k=boids.get(j);
            }
        }
        return k;
    }
}
