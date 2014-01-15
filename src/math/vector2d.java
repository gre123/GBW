package math;

import boids.boid;
import static java.lang.StrictMath.sqrt;

/**
 * @author Tomek
 */
public class vector2d {
    double x,y;
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double _x){
        x=_x;
    }
    public void setY(double _y){
        y=_y;
    }
    public double getLength(){
        return sqrt(x*x+y*y);
    }
    public double getSLength(){
        return x*x+y*y;
    }
    public vector2d normalize(){
    double d = getLength();
    if (d==0){return this;}
    x=x/d;
    y=y/d;
    return this;
    }
    public double getDistance(boid b){
        double dX=(x-b.getX());
        double dY=(y-b.getY());   
    return sqrt(dX*dX+dY*dY);
    }
    
    public double getDistance(vector2d _pos){
        double dX=(x-_pos.x);
        double dY=(y-_pos.y);   
    return sqrt(dX*dX+dY*dY);
    }
    public double getSDistance(boid b){
        double dX=(x-b.getX());
        double dY=(y-b.getY());   
    return dX*dX+dY*dY;
    }
    public double getSDistance(vector2d _pos){
        double dX=(x-_pos.x);
        double dY=(y-_pos.y);
    return dX*dX+dY*dY;
    }
    
     /**
     * Liczy pozycje uwzglednajac zawijanie krawędzi, strasznie wolne nie uzywać!! lepsza wersja w boid.java
     * @param _pos  Pozycja ktorej wspolrzedne chcemy policzyc
     * @param sizeX szerokosc planszy w px
     * @param sizeY wysokość planszy w px
     * @return najblizsza pozycja
     */
    public vector2d getCloserPosition(vector2d _pos,double sizeX,double sizeY){
    double dist1,dist2,dist3,dist4;
    double dist11,dist22,dist33,dist44,dist00 ;
    vector2d close;
    double bestDist;
    dist1=this.getSDistance(_pos);
    dist2=this.getSDistance(_pos.getVec().add(new vector2d(sizeX,0)));
    if (dist1<dist2){bestDist=dist1;close=_pos.getVec();}else{bestDist=dist2;close=_pos.getVec().add(new vector2d(sizeX,0));}
    
    dist3=this.getSDistance(_pos.getVec().add(new vector2d(0,sizeY)));
    if (bestDist>dist3){bestDist=dist3;close=_pos.getVec().add(new vector2d(0,sizeY));}
    dist4=this.getSDistance(_pos.getVec().add(new vector2d(sizeX,sizeY)));
    if (bestDist>dist4){bestDist=dist4;close=_pos.getVec().add(new vector2d(sizeX,sizeY));}
    
    dist00=this.getSDistance(_pos.getVec().add(new vector2d(sizeX,-sizeY)));
    if (bestDist>dist00){bestDist=dist00;close=_pos.getVec().add(new vector2d(sizeX,-sizeY));}
    
    dist11=this.getSDistance(_pos.getVec().add(new vector2d(-sizeX,sizeY)));
    if (bestDist>dist11){bestDist=dist11;close=_pos.getVec().add(new vector2d(-sizeX,sizeY));}
    
    dist22=this.getSDistance(_pos.getVec().add(new vector2d(-sizeX,0)));
    if (bestDist>dist22){bestDist=dist22;close=_pos.getVec().add(new vector2d(-sizeX,0));}
    
    dist33=this.getSDistance(_pos.getVec().add(new vector2d(0,-sizeY)));
    if (bestDist>dist33){bestDist=dist33;close=_pos.getVec().add(new vector2d(0,-sizeY));}
 
    dist44=this.getSDistance(_pos.getVec().add(new vector2d(-sizeX,-sizeY)));
    if (bestDist>dist44){close=_pos.getVec().add(new vector2d(-sizeX,-sizeY));}
    
    return close;
    }
    public vector2d(double _x,double _y){
        x=_x;
        y=_y;
    }
    public vector2d add(vector2d vec){
        this.x=vec.x+this.x;
        this.y=vec.y+this.y;
        return this;
    }
    public vector2d add(double x,double y){
        this.x=x+this.x;
        this.y=y+this.y;
        return this;
    }
    public vector2d minus(vector2d vec){
        this.x=this.x-vec.x;
        this.y=this.y-vec.y;
        return this;
    }
    public vector2d multi(double a){
        this.x=this.x*a;
        this.y=this.y*a;
        return this;
    }
    public vector2d div(double a){
        if (a!=0){
        this.x=this.x/a;
        this.y=this.y/a;
        }
        return this;
    }
    
    public vector2d divNonZero(double a){
        this.x=this.x/a;
        this.y=this.y/a;
        
        return this;
    }
    public vector2d getVec(){
        return  new vector2d(this.x,this.y);
    }
    public double skalarny(vector2d a){ 
        return x*a.x+y*a.y;
    }
    public double skalarny(double _x, double _y){
        return x*_x+y*_y;
    }
/**
 * @return Zwraca wektor obrócony 90* w prawo
 */
    public vector2d getRight(){
        return new vector2d(y,-x);
    }
    public vector2d getLeft(){
        return new vector2d(-y,x);
    }
    
}
