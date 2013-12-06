/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boids;

import java.util.ArrayList;
import math.vector2d;

/**
 *
 * @author Grzesiek
 * Nieskonczone !
 */
public class PBehaviour {
    public static vector2d escapeP(boid ten,ArrayList<boid> boids)
    {
        vector2d poz,pom=new vector2d(0,0);
        vector2d w=new vector2d(0,0);
        
        if(ten.type==2||boids.isEmpty()) return pom;
        for(int i=0;i<boids.size();i++)
        {
            if(boids.get(i).type==2)
            {
                poz=boids.get(i).getPosition().getVec();
                pom=poz.minus(ten.position);
                pom=pom.multi(-1);
                
                w.add(pom);
            } 
        }
        return w;
    }
}
