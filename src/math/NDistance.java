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
    public static boid minDist(boid ten,ArrayList<boid> boids)
    {
        double pom;
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
