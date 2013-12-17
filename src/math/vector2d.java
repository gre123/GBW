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
    public vector2d normalize(){
    double d = getLength();
    if (d==0){return this;}
    x=x/d;
    y=y/d;
    return this;
    }
    public double getDistance(boid b){

    return sqrt((x-b.getX())*(x-b.getX())+(y-b.getY())*(y-b.getY()));
    }
    
    public double getDistance(vector2d _pos){

    return sqrt((x-_pos.x)*(x-_pos.x)+(y-_pos.y)*(y-_pos.y));
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
    public vector2d getVec(){
        vector2d temp=new vector2d(this.x,this.y);
        return temp;
    }
    public double skalarny(vector2d a){
        double wynik = x*a.getX()+y*a.getY();
        return wynik;
    }
    
}
