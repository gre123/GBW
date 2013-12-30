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
    /**
     * ma udawać zachowanie uciekających
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d escapeP(boid ten,ArrayList<boid> boids)
    {
        vector2d poz,pom=new vector2d(0,0);
        vector2d w=new vector2d(0,0);
        double criticaldist=20;
        double d;
        Random randGen = new Random();
        
        if(ten.type==2||boids.isEmpty()) return pom;
        for(int i=0;i<boids.size();i++)
        {
            if(boids.get(i).type==2)
            {
                  d=ten.getPosition().getDistance(boids.get(i));
                  /**
                   *  Zachowanie ucieczki w sytuacji krytycznej, ucieczka wgłąb stada(?)
                   */
                  if(d<criticaldist && randGen.nextBoolean() && mainBoids.mainWin.getEscapeStrategy()==0)
                  {
                      mainBoids.simul.critical_sit=true;
                  }
                  /**
                   * Zachowanie ucieczki w stadzie
                   */
                  else{
                    
                    poz=boids.get(i).getPosition().getVec();
                    pom=poz.minus(ten.position);
                    pom=pom.multi(-1);
                    
                   /**
                    *  Zachowanie ucieczki w sytuacji krytycznej , ucieczka w jakimś kierunku
                    */
                    if(d<criticaldist && randGen.nextBoolean() && mainBoids.mainWin.getEscapeStrategy()==1)
                    {
                        mainBoids.simul.critical_sit=true;
                        if(pom.getX()>pom.getY())
                        {
                            pom.setY(pom.getY()*5);
                            pom.multi(10);
                        }
                        else
                        {
                            pom.setX(pom.getX()*5);
                            pom.multi(10);
                        }
                    }
               
                    if(d>25) w.add(pom.div(d));
                    else 
                    {
                        w.add(pom);
                    }
                //w.add(pom);
                 
                  } 
            } 
        }
        return w;
    }
    
    /**
     * ma zwracać najliczniejszy koszyk
     * @param ten
     * @param bucketboids
     * @return 
     */
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
     * fkcja ma zwracać najliczniejsze sąsiedztwo znalezione wśród sąsiedztw sąsiadów drapieżnika xD
     * @param ten
     * @param boids
     * @return 
     */
    public static ArrayList<boid> getCrowdedGroup(boid ten,ArrayList<boid> boids)
    {
        int ind,t,max=0;
        ind=0;
        ArrayList<boid> pom=new ArrayList<boid>();
        for(int i=0;i<boids.size();i++)
        {
           t=mainBoids.simul.getNeighbourhoodOptm(boids.get(i)).size();
           if(max<t)
           {
               max=t;
               ind=i;
           }
               
        }
        if(max!=0)
        {
            return mainBoids.simul.getNeighbourhoodOptm(boids.get(ind));
        }
        else return pom;
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
          //pom=new vector2d(randGen.nextDouble()-2,randGen.nextDouble()+4);
            pom=new vector2d(0,0);
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
         return pom.normalize();
            
    }
    /**
     * Biegnie za najbliższym osobnikiem jeśli takowego ma w sąsiedztwie
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d huntStrategy2(boid ten,ArrayList<boid> boids)
    {
       // Random randGen = new Random();
        boid mD=null;
        vector2d pom=new vector2d(0,0);
        
        mD=NDistance.minDist(ten, boids);
        if(mD!=null)
        { 
                pom.add(mD.getPosition());
                pom.minus(ten.getPosition());  
                pom.normalize();
                  //  System.out.println("["+pom.getX()+" ; "+pom.getY()+"]");
            return pom;
        }
        else return pom;
    }
    /**
     * Biegnie za grupą wyznaczoną za pomocą sąsiedztwa jednego z sąsiadów drapieżnika
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d huntStrategy3(boid ten,ArrayList<boid> boids)
    {
        Random randGen = new Random();
        ArrayList <boid> tmp=new ArrayList <>();
        vector2d move=new vector2d(0,0);
        tmp=getCrowdedGroup(ten,boids);
        if(!tmp.isEmpty())
        {
            for(int i=0;i<tmp.size();i++)
            {
                move.add(tmp.get(i).getPosition());
            }
            move.div(tmp.size());
            move.minus(ten.getPosition());
            move.normalize();
            return move;
        }
        else return new vector2d(randGen.nextDouble()-2,randGen.nextDouble()+4).normalize();
    }
    
    /**
     * Połączenie : powyżej odleglosci chStrategy porusza sie wedlug strategii 3, poniżej wedlug najbliższego sąsiada
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d huntStrategy2_3(boid ten,ArrayList<boid> boids)
    {
        Random randGen = new Random();
        double chStrategy=30;
        boid mD=null;
        vector2d pom=new vector2d(0,0);
        mD=NDistance.minDist(ten, boids);
        if(mD!=null)
        {
            if(ten.getPosition().getDistance(mD)<chStrategy)
            {
                pom.add(mD.getPosition());
                pom.minus(ten.getPosition());  
                pom.normalize();
                return pom;
            }
            else
            {
                return huntStrategy3(ten,boids);
            }
        }
        return new vector2d(randGen.nextDouble()-2,randGen.nextDouble()+1).normalize();  

    }
    
    
    
    
    public static vector2d huntP(boid ten,ArrayList<boid> boids,ArrayList<bucket> bucketboids,ArrayList<boid> wszystkie)
    {
        boid potPrey;
        int str;
        
       // if(ten.type==2)
     //   {
           /**
            * Atakowanie najbliższej potencjalnej zdobyczy, jeśli jest w zasięgu drapieżnika
            */ 
            
            if(!boids.isEmpty())
            {
                 potPrey=NDistance.minPrey(ten, boids,7);
                 if(potPrey!=null){
                   wszystkie.remove(potPrey);
                   
                   //boids.remove(potPrey);
                 } 
            }  
            
            /**
             * Strategia poruszania się
             */
            str=mainBoids.mainWin.getHuntStrategy();
            if(str==0)
            return huntStrategy1(ten,boids,bucketboids);
            else
            {
                if(str==1) {
                    return huntStrategy2(ten,boids);
                }
                else 
                {
                    if(str==2) return huntStrategy3(ten,boids);
                    else 
                    {
                        if(str==3) return huntStrategy2_3(ten,boids);
                        else return new vector2d(0,0);
                    } // żeby coś bylo
                }
            }      
       // }
       // else return new vector2d(0,0);
     }
}

