
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
 /**
  * Sprawdzanie czy drapieżnik jest w koszyku
  * @param b drapieżnik do sprawdzania
  * @return true : drapieznik jest w tym koszyku, false : nie ma go
  */
 public boolean ifPred(boid b)
 {
     for(int i=0;i<koszyk.size();i++)
     {
         if(b.equals(koszyk.get(i))) return true;
     }
     return false;
 }
 //--------------------------------------------
}
