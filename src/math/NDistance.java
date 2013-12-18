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
public class NDistance {
    public static boid minPrey(boid ten,ArrayList<boid> boids)
    {
        double preyDistance=15;
        double pom=0;
        boid k=null;
        double d=999999; //to zmienić?
        for(int j=0;j<boids.size();j++)
        {
            pom=ten.getPosition().getDistance(boids.get(j));
            if(d>pom) 
            {
                d=pom; 
                k=boids.get(j);
            }
        }
        if (k==null) return k;
        if(pom<=preyDistance) return k;
        else return null;
   
    }
    
    public static boid minDist(boid ten,ArrayList<boid> boids)
    {
        double pom=0;
        boid k=null;
        double d=999999; //to zmienić?
        for(int j=0;j<boids.size();j++)
        {
            pom=ten.getPosition().getDistance(boids.get(j));
            if(d>pom) 
            {
                d=pom; 
                k=boids.get(j);
            }
        }
        return k;
    }
}
