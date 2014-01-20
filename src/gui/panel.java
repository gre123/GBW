package gui;
import boids.Food;
import boids.boid;
import boids.mainBoids;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import trunk.src.boids.Obstacle;
 
/**
 *@author  Gajda
 */
public class panel extends JPanel {
    public ArrayList<boid> boids;
    public ArrayList<Obstacle> obs;
    public ArrayList<Food> food;
    BufferedImage wrobel;
    
    boolean isRect=false;
    double recX,recY;
    int recSizeX,recSizeY;
    
    boolean isImage=false;
    int x,y;
    int aimX=-1,aimY=-1;
    public panel(ArrayList<boid> _boids) {
        x=1080;
        y=685;
        setPreferredSize(new Dimension(x, y));
        boids=_boids;    
        setSize(x, y);
        setBackground(Color.getHSBColor(0.5f, 0.14f, 1));
        setLocation(11, 11);
      
        repaint();
    }
    
    public panel(ArrayList<boid> _boids, ArrayList<Obstacle> _obs, ArrayList<Food> _food) {
        x=mainBoids.panelSizeX;
        y=mainBoids.panelSizeY;
        setPreferredSize(new Dimension(x, y));
        boids=_boids;
        obs = _obs;
        food=_food;
        setSize(x, y);
        setBackground(Color.getHSBColor(0.5f, 0.14f, 1));
        setLocation(11, 11);
        repaint();
    }
 
    public void drRec(double x, double y , int sizeX,int sizeY)
    {
        isRect=true;
        recX=x;
        recY=y;
        recSizeX=sizeX;
        recSizeY=sizeY;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
    
    public void paint(Graphics gContext) {  
        super.paintComponent(gContext);
        Graphics2D g2d = (Graphics2D) gContext;
        
        try{
            wrobel=ImageIO.read(new File("D:\\wrobel.gif"));
            isImage=true;
        }catch(Exception e)
        {  
            isImage=false;
        }
        
        if (boids!=null){
          //System.out.println(boids.size());
            double r;
            for(int i=0;i<boids.size();i++){ 
                r=boids.get(i).getR();
                if (boids.get(i).getType()==1){//zwykły
                    //if (boids.get(i).czyOmijam()){
                    //    g2d.setColor(Color.ORANGE);
                    //}else 
                    if (mainBoids.mainWin.czyWplywLeader()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorLeadB()));
                    }else if(mainBoids.mainWin.czyAccelWart()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorAccelB()));
                    }else if(mainBoids.mainWin.czyVelWart()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorVelB()));
                    }else if(mainBoids.mainWin.czySeparacja()){
                    g2d.setColor(Color.getHSBColor(boids.get(i).getColorSepH(), 1, 1));
                    }else if(mainBoids.mainWin.czyPolarizationWyglad()){
                    g2d.setColor(Color.getHSBColor(boids.get(i).getColorOdstVelH(), 1, 1));
                    }else if(mainBoids.mainWin.czyPolarizationLokalWyglad()){
                    g2d.setColor(Color.getHSBColor(boids.get(i).getColorOdstVelLokalH(), 1, 1));
                    }else{ g2d.setColor(Color.black);}
                }else if(boids.get(i).getType()==0){//leader
                    g2d.setColor(Color.blue);
                }else if(boids.get(i).getType()==2) {//przeciwnik
                    g2d.setColor(Color.red);
                }
                //-----------------------------------------------------------------
                //if(boids.get(i).isHungry()) g2d.setColor(Color.CYAN);
                 /**
                  * Tu jakaś próba wstawienia obrazku ptaka
                  */
               if(isImage) 
               {
                  g2d.drawImage(wrobel,(int)(boids.get(i).getX()-r/2), (int)boids.get(i).getY(),null);
               }
               else {
                Ellipse2D circle = new Ellipse2D.Double( boids.get(i).getX()-r/2, boids.get(i).getY()-r/2, r,r);
                g2d.fill(circle);
                g2d.draw(circle);
               }
               //-----------------------------------------------------------------
            } 
            
        }
       
        
        if (obs!=null || !obs.isEmpty()){
            for(int i=0;i<obs.size();i++){
               g2d.setColor(Color.GRAY); 
               Ellipse2D circle = new Ellipse2D.Double(obs.get(i).getX()-obs.get(i).getR(), obs.get(i).getY()-obs.get(i).getR(), obs.get(i).getR()*2,obs.get(i).getR()*2);
               g2d.fill(circle);
               g2d.draw(circle);
            }
        }
        
        if (aimX>=0 &&aimY>=0){
        Ellipse2D circle = new Ellipse2D.Double(aimX-5, aimY-5, 10,10);
        g2d.setColor(Color.PINK);
        g2d.fill(circle);
        g2d.draw(circle);
        }
        
        if(food!=null && !food.isEmpty())
        {
            g2d.setColor(Color.green); 
            for(int i=0;i<food.size();i++)
            {
                
                Ellipse2D circle = new Ellipse2D.Double(food.get(i).getX()-13, food.get(i).getY()-13, 26,26);
               g2d.draw(circle);
              //  g2d.fill(circle)
             
                for(int j=0;j<food.get(i).cir.size();j++)
                {
                    g2d.draw(food.get(i).cir.get(j));
                    g2d.fill(food.get(i).cir.get(j));
                }
                
            }
        }
        if(isRect)
        {
            g2d.setColor(Color.red); 
            g2d.drawRect((int)recX, (int)recY,recSizeX,recSizeY);
            isRect=false;
        }
        
        }
    public void drawAim( Graphics2D g2d,int x,int y,int r){
        
        
    }    
}  
    
    
