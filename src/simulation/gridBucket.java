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
      double sizeX,sizeY;
      double maxX,maxY;
      public gridBucket(int _x,int _y,double _sizeX, double _sizeY,double _maxX, double _maxY){
      x=_x;
      y=_y;
      sizeX=_sizeX; 
      sizeY=_sizeY;
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
          for(int i=0;i<boids.size();i++){
          int posX,posY;    
          vector2d pos=boids.get(i).getPosition().getVec();
          posX=(int)(pos.getX()/maxX*(x));
          posY=(int)(pos.getY()/maxY*(y));
          boids.get(i).setBucket(posX,posY);
          bucketList.get(posX).get(posY).koszyk.add(boids.get(i));
          }
      }
      public void updateGrid(boid osobnik){
          int posX,posY;    
          vector2d pos=osobnik.getPosition().getVec();
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
      int dX=osobnik.getBucketX()+2;
      int dY=osobnik.getBucketY()+2;
      int k=0;
      for (int i=dX-3;i<dX;i++){
          if (i<0 || i>=x){continue;}
          for (int j=dY-3;j<dY;j++){
               if (j<0 || j>=y){continue;}
               k++;
               temp.addAll(bucketList.get(i).get(j).koszyk);//tu moze bez kopiowania calych koszyków
          }
      }
   //  System.out.println("t"+k);
      
      return temp;
      }
}
