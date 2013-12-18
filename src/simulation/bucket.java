
package simulation;

import boids.boid;
import java.util.ArrayList;

/**
 * @author Tomek
 */
public class bucket {
 int x,y;
 double sizeX,sizeY;
 ArrayList <boid> koszyk;
 public bucket(){
    koszyk=new ArrayList<>();
 }
 
 //-------------------------------------------
 /**
  * funkcja ma liczyć wszystkich osobników w koszyku bez drapieżników
  * @return 
  */
 public int count_noPred()
 {
     int s=0;
     for(int i=0;i<koszyk.size();i++)
     {
         if(koszyk.get(i).getType()!=2) s++;
     }
     return s;
 }
 /**
  * Funkcja zwraca koszyk
  * @return koszyk
  */
 public ArrayList<boid> getKoszyk()
 {
     return koszyk;
 }
 //--------------------------------------------
}
