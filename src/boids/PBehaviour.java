/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boids;

import java.util.ArrayList;
import java.util.Random;
import math.NDistance;
import math.vector2d;
import simulation.bucket;

/**
 *
 * @author Grzesiek
 * Nieskończone !
 */
public class PBehaviour {
    public static vector2d escapeP(boid ten,ArrayList<boid> boids)
    {
        vector2d poz,pom=new vector2d(0,0);
        vector2d w=new vector2d(0,0);
        double d;
        
        if(ten.type==2||boids.isEmpty()) return pom;
        for(int i=0;i<boids.size();i++)
        {
            if(boids.get(i).type==2)
            {
                d=ten.getPosition().getDistance(boids.get(i));
                poz=boids.get(i).getPosition().getVec();
                pom=poz.minus(ten.position);
                pom=pom.multi(-1);
                
               // if(d>20) w.add(pom.div(d));
              //  else w.add(pom);
                w.add(pom);
                
            } 
        }
        return w;
    }
    
    public static vector2d huntP(boid ten,ArrayList<boid> boids,ArrayList<bucket> bucketboids,ArrayList<boid> wszystkie)
    {
        boid potPrey;
        ArrayList <bucket> temp=new ArrayList <>();
        vector2d poz,pom=new vector2d(0,0);
        Random randGen = new Random();
        
        if(ten.type==2)
        {
            
            if(!boids.isEmpty())
            {
                 potPrey=NDistance.minDist(ten, boids);
                 if(potPrey!=null && potPrey.type!=2){
                   wszystkie.remove(potPrey);
                 }
            }
            
            
            pom=new vector2d(randGen.nextDouble()*12-5,randGen.nextDouble()*12-5);
            return pom;
        }
        else return pom;
       
    }
}

