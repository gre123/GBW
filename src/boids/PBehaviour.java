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
    public static ArrayList<boid> getCrowdedBucket(boid ten, ArrayList<bucket> bucketboids)
    {
        int pom,a=0;
        ArrayList<boid> w=new ArrayList<boid>();
        ArrayList<boid> wynik=new ArrayList<boid>();
        for(int i=0;i<bucketboids.size();i++)
        {
            pom=bucketboids.get(i).count_noPred();
            if(pom>a)
            {
                a=pom;
                w=bucketboids.get(i).getKoszyk();
            }
        }
        for(int i=0;i<w.size();i++)
        {
            if(w.get(i).getType()!=2) wynik.add(w.get(i));
        }
        return wynik;
    }
    /**
     * Strategia oparta na gonieniu za osobnikami w najliczniejszym koszyku
     * @param ten
     * @param boids
     * @param bucketboids
     * @return 
     */
    public static vector2d huntStrategy1(boid ten,ArrayList<boid> boids,ArrayList<bucket> bucketboids)
    { 
       
        boid minDist;
        ArrayList <boid> tmp=new ArrayList <>();
        vector2d mindist,pom=new vector2d(0,0);
        Random randGen = new Random();
        
        minDist=NDistance.minDist(ten, boids);
        tmp=getCrowdedBucket(ten,bucketboids);
        
        if(tmp.isEmpty())
        {
          pom=new vector2d(randGen.nextDouble()*2-2,randGen.nextDouble()*2+4);
        }
        else 
        {
           for(int j=0;j<tmp.size();j++)
           {
             pom.add(tmp.get(j).getPosition());
           }
           pom.div(tmp.size());
           pom.minus(ten.getPosition());
         }
         return pom.normalize().multi(10);
            
    }
    public static vector2d huntP(boid ten,ArrayList<boid> boids,ArrayList<bucket> bucketboids,ArrayList<boid> wszystkie)
    {
        boid potPrey;
        
        
        if(ten.type==2)
        {
           /**
            * Atakowanie najbliższej potencjalnej zdobyczy, jeśli jest w zasięgu drapieżnika
            */ 
            if(!boids.isEmpty())
            {
                 potPrey=NDistance.minPrey(ten, boids);
                 if(potPrey!=null && potPrey.type!=2){
                   wszystkie.remove(potPrey);
                 } 
            } 
            /**
             * Strategia poruszania się
             */
            return huntStrategy1(ten,boids,bucketboids);
       
        }
        else return new vector2d(0,0);
     }
}

