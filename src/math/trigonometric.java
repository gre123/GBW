package math;

/**
 * @author Tomek
 */
public class trigonometric {
  static  double[]  lutAtan;
  static   int endLUT;
  static   int precLUT;
  static double[] lutAcos;
    public  trigonometric(int end,int n){
        lutAtan=new double[n+1];
        lutAcos=new double[n+1];
        endLUT=end;
        precLUT=n;
        for(int i=0;i<=n;i++){
        lutAtan[i]=Math.atan(end*i/(double)n);
        lutAcos[i]=Math.acos(-1+2/(double)precLUT*i);
        }      
    }
    
  public static double atanLUT(double l,double m){
      if(m==0){m=0.00000000001;}
      double angle =l/m;
      if (Math.abs(angle)>endLUT){angle=endLUT;}
  if (angle>0){
      return  lutAtan[(int)(angle*precLUT/endLUT)];
  }else{
      return -lutAtan[-(int)(angle*precLUT/endLUT)];
  }}
  public static double acosLUT(double a){
      return lutAcos[(int)((a+1)*(double)precLUT/2) ];
  }
}
