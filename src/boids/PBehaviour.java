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
        if(!ten.getHavePredator()) {return pom;}
        vector2d bestPos,w=new vector2d(0,0);
        double criticaldist=3*ten.skala;
        double d;
        int k=0;
       
        for(int i=0;i<boids.size();i++)
        {
            if(boids.get(i).type==2)
            {
                    bestPos=ten.getBestPosition(boids.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY);
                    d=ten.getPosition().getDistance(bestPos);             
                    poz=bestPos;
                    pom=poz.minus(ten.position);
                    pom=pom.multi(-1);
                    
                   /**
                    *  Zachowanie ucieczki w sytuacji krytycznej , ucieczka w jakimś kierunku
                    */
                    if(d<criticaldist)
                    {
                        if(mainBoids.mainWin.getEscapeStrategy()==1)
                        {
                            mainBoids.simul.critical_sit=true;
                            pom=ten.velocity.getVec();
                            pom.rotate(Math.toRadians(30));
                           
                           pom.normalize();
                           // pom.div(mainBoids.mainWin.getEscapePred()/(double)1000);
                           // pom.multi(2);
                            w.add(pom);k++;
                         }  
                    } 
                    else
                         {
                            if(d>criticaldist){ w.add(pom);k++;}
                             else 
                             {
                                 pom.normalize().multi(d/criticaldist);
                                 w.add(pom);
                                 k++;
                             }
                         } 
        }
        
    }
        return w.div(k).normalize();
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
        ArrayList<boid> w=new ArrayList<>();
        ArrayList<boid> wynik=new ArrayList<>();
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
            if(w.get(i).getType()!=2){ wynik.add(w.get(i));}
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
        ArrayList <boid> tmp;
        vector2d mindist,bestPos,pom=new vector2d(0,0);
        
        minDist=NDistance.minDist(ten, boids);
        tmp=getCrowdedBucket(ten,bucketboids);
        
        if(tmp.isEmpty())
        {
            pom=new vector2d(0,0);
        }
        else 
        {
           for(int j=0;j<tmp.size();j++)
           {
             bestPos=ten.getBestPosition(tmp.get(j), mainBoids.panelSizeX, mainBoids.panelSizeY);  
             pom.add(bestPos);
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
     * @return siłę w stronę ofiary
     */
    public static vector2d huntStrategy2(boid ten,ArrayList<boid> boids)//tu dodac pozniej trzeba oblsuge krawedzi - zulov
    //obsługa krawędzi chyba działałaby, gdyby w liście boidów z argumentu były podawane też te poza krawędzią, a to wymaga zmian aż w getNeighborhoodOptm, więc nie warto
    {
       // Random randGen = new Random();
        boid mD;
        vector2d pom=new vector2d(0,0);
        
        mD=NDistance.minDist(ten, boids);//zwraca najbliższego przez ściany z podanej listy
        if(mD!=null)
        { 
                if(mD.getPosition().getDistance(ten)<1) ten.velocity=new vector2d(0,0);
                pom.add(ten.getBestPosition(mD, mainBoids.panelSizeX, mainBoids.panelSizeY));
                pom.minus(ten.getPosition());  
                pom.normalize();
            return pom;
        }
        
        else {
            return pom;
        }
    }
    /**
     * Biegnie za grupą wyznaczoną za pomocą sąsiedztwa jednego z sąsiadów drapieżnika
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d huntStrategy3(boid ten,ArrayList<boid> boids)
    {
        ArrayList <boid> tmp=new ArrayList <>();
        vector2d bestPos,move=new vector2d(0,0);
        tmp=getCrowdedGroup(ten,boids);
        if(!tmp.isEmpty())
        {
            for(int i=0;i<tmp.size();i++)
            {
                bestPos=ten.getBestPosition(tmp.get(i), mainBoids.panelSizeX, mainBoids.panelSizeY);
                move.add(bestPos);
            }
            move.div(tmp.size());
            move.minus(ten.getPosition());
            move.normalize();
            return move;
        }
        else return new vector2d(0,0);
    }
    
    /**
     * Połączenie : powyżej odleglosci chStrategy porusza sie wedlug strategii 3, poniżej wedlug najbliższego sąsiada
     * @param ten
     * @param boids
     * @return 
     */
    public static vector2d huntStrategy2_3(boid ten,ArrayList<boid> boids)//dodana obsługa krawędzi, gdyby arraylista zawierała też te poza krawędzią
    {
        Random randGen = new Random();
        double chStrategy=mainBoids.mainWin.getChangeStrategy()*ten.skala/10;
        boid mD=null;
        vector2d pom=new vector2d(0,0);
        mD=NDistance.minDist(ten, boids);//mindist zwraca też przez ściany
        if(mD!=null)
        {
            if(ten.getPosition().getDistance(ten.getBestPosition(mD,mainBoids.panelSizeX, mainBoids.panelSizeY))<chStrategy)
            {
              //  if(mD.getPosition().getDistance(ten)<1) ten.velocity=new vector2d(0,0); 
                pom.add(ten.getBestPosition(mD,mainBoids.panelSizeX, mainBoids.panelSizeY));
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
    
    public static vector2d huntP(boid ten, ArrayList<boid> boids, ArrayList<bucket> bucketboids) {
        boid potPrey;
        Random randGen = new Random();
        int str;
        /**
         * Atakowanie najbliższej potencjalnej zdobyczy, jeśli jest w zasięgu
         * drapieżnika
         */
        if (!boids.isEmpty()) {
            potPrey = NDistance.minPrey(ten, boids, ten.minimalDistance * 2);
            if (potPrey != null) {
                if (randGen.nextInt(101) <= mainBoids.mainWin.getFreqEat()) {
                    //mainBoids.mainWin.fabric.boids.remove(potPrey);
                    ten.velocity.setX(0);
                    ten.velocity.setY(0);
                    
                    mainBoids.simul.boids.remove(potPrey);
                    mainBoids.simul.siatkaKoszykow.bucketList.get(potPrey.getBucketX()).get(potPrey.getBucketY()).getKoszyk().remove(potPrey); 
                    //boids.remove(potPrey);
                    //mainBoids.boids.remove(potPrey);
                    
                }
            }
        }

        /**
         * Strategia poruszania się
         */
        str = mainBoids.mainWin.getHuntStrategy();
        if (str == 0) {
            return huntStrategy1(ten, boids, bucketboids);
        } else {
            if (str == 1) {
                return huntStrategy2(ten, boids);
            } else {
                if (str == 2) {
                    return huntStrategy3(ten, boids);
                } else {
                    if (str == 3) {
                        return huntStrategy2_3(ten, boids);
                    } else {
                        return new vector2d(0, 0);
                    }
                }
            }
        }
    }
}

