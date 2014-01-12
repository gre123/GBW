package simulation;

import boids.boid;
import java.util.ArrayList;
import math.vector2d;

/**
 * @author Tomek
 */
public class gridBucket {
      ArrayList<ArrayList <bucket>> bucketList; 
      int x,y;
      //double sizeX,sizeY;
      double maxX,maxY;
      public gridBucket(int _x,int _y,double _maxX, double _maxY){
      x=_x;
      y=_y;
      maxX=_maxX;
      maxY=_maxY;
      
      bucketList=new ArrayList<>();
      for(int i=0;i<x;i++){//zbudowanie dwu wymiarowej tablicy z koszykami
          bucketList.add(new ArrayList <bucket>());
          for(int j=0;j<y;j++){
           bucketList.get(i).add(new bucket());
          }
      }
      }
      public void writeToGrid(ArrayList<boid> boids){
          int posX,posY;
           vector2d pos;
          for(int i=0;i<boids.size();i++){  
          pos=boids.get(i).getPosition();
          posX=(int)(pos.getX()/maxX*(x));
          posY=(int)(pos.getY()/maxY*(y));
          boids.get(i).setBucket(posX,posY);
          bucketList.get(posX).get(posY).koszyk.add(boids.get(i));
          }
      }
      public void updateGrid(boid osobnik){
          int posX,posY;    
          vector2d pos=osobnik.getPosition();
          posX=(int)(pos.getX()/maxX*(x));
          posY=(int)(pos.getY()/maxY*(y));
          if (osobnik.checkBucketXY(posX,posY)==true){
              bucketList.get(osobnik.getBucketX()).get(osobnik.getBucketY()).koszyk.remove(osobnik);  
              osobnik.setBucket(posX, posY);
              bucketList.get(posX).get(posY).koszyk.add(osobnik);
          }
      }
      public ArrayList <boid> getArrayNeight(boid osobnik){
      ArrayList <boid> temp=new ArrayList <>();
      temp.ensureCapacity(400);
      int dX=osobnik.getBucketX()+2;
      int dY=osobnik.getBucketY()+2;
      for (int i=dX-3;i<dX;i++){
          if (i<0 || i>=x){continue;}
          for (int j=dY-3;j<dY;j++){
               if (j<0 || j>=y){continue;}
               temp.addAll(bucketList.get(i).get(j).koszyk);//tu moze bez kopiowania calych koszyków
          }
      }
      return temp;
      }
      
      public ArrayList <boid> getArrayNeightEdge(boid osobnik){
      ArrayList <boid> temp=new ArrayList <>();
      temp.ensureCapacity(400);
      int dX=osobnik.getBucketX()+2;
      int dY=osobnik.getBucketY()+2;
      temp.addAll(bucketList.get(dX-2).get(dY-2).koszyk);
      for (int i=dX-3;i<dX;i++){      
          for (int j=dY-3;j<dY;j++){
             if (i==dX-2 && j==dY-2){continue;}
             if (j>=0 && j<y && i>=0 && i<x){temp.addAll(bucketList.get(i).get(j).koszyk);}  
             else if (j<0 && i<0){temp.addAll(bucketList.get(x-1).get(y-1).koszyk);continue;}
             else if (j>=y && i<0){temp.addAll(bucketList.get(x-1).get(0).koszyk);continue;}
             else if (i>=x && j<0){temp.addAll(bucketList.get(0).get(y-1).koszyk);continue;}
             else if (j>=y && i>=x){temp.addAll(bucketList.get(0).get(0).koszyk);continue;}
             else if (j>=y){temp.addAll(bucketList.get(i).get(0).koszyk);continue;}
             else if (i>=x){temp.addAll(bucketList.get(0).get(j).koszyk);continue;}
             else if (j<0){temp.addAll(bucketList.get(0).get(y-1).koszyk);continue;}
             else if (i<0){temp.addAll(bucketList.get(x-1).get(j).koszyk);continue;}
             //temp.addAll(bucketList.get(i).get(j).koszyk);
          }
      }
     // System.out.println(temp.size());
      return temp;
      }
      
      //-------------------------------------------
      /**
       * Fajnie by było żeby fkcja zwracała buckety sąsiadujące z drapieżnikiem :P
       * Ogólnie prawie kopiuj-wklej z getArrayNeight
       * @param osobnik
       * @return 
       */
      public ArrayList <bucket> getArrayNeightB(boid osobnik){
      ArrayList <bucket> temp=new ArrayList <>();
      int dX=osobnik.getBucketX()+2;
      int dY=osobnik.getBucketY()+2;
      int k=0;
      for (int i=dX-3;i<dX;i++){
          if (i<0 || i>=x){continue;}
          for (int j=dY-3;j<dY;j++){
               if (j<0 || j>=y){continue;}
               k++;
               temp.add(bucketList.get(i).get(j));
          }
      }
      
      return temp;
      }

}
