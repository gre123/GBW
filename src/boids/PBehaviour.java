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
    
    public static vector2d huntP(boid ten,ArrayList<boid> boids,ArrayList<boid> prey,ArrayList<boid> wszystkie)
    {
        boid naj;
        vector2d poz,pom=new vector2d(0,0);
        Random randGen = new Random();
        /**
        if(ten.type==2)
        {
            //System.out.println(ten.getAcceleration().getX());
            if(ten.eats!=-1 && ten.eats<10000) {
                ten.eats++;
                return pom;
            }
            if(!boids.isEmpty())
            {
                 naj=NDistance.minDist(ten, boids);
                 if(naj!=null && naj.type!=2){
                   naj.type=3; //nie mam pojęcia czy to tak zadziała
                   prey.add(naj);
                   wszystkie.remove(naj);
                 }
                 ten.eats=0;
                 ten.velocity=new vector2d(0,0);
                 return pom;
            }
            **/
           if(ten.type==2) pom=new vector2d(randGen.nextDouble()*12-5,randGen.nextDouble()*12-5);
            return pom;
       // }
        //else return pom;
    }
}
