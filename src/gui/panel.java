package gui;
import boids.boid;
import boids.mainBoids;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import trunk.src.boids.Obstacle;
 
public class panel extends JPanel {
    public ArrayList<boid> boids,prey;
    public ArrayList<Obstacle> obs;
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
    
    public panel(ArrayList<boid> _boids, ArrayList<Obstacle> _obs) {
        x=1080;
        y=685;
        setPreferredSize(new Dimension(x, y));
        boids=_boids;
        obs = _obs;
        setSize(x, y);
        setBackground(Color.getHSBColor(0.5f, 0.14f, 1));
        setLocation(11, 11);
        repaint();
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
    
    public void paint(Graphics gContext) {  
        super.paintComponent(gContext);
        Graphics2D g2d = (Graphics2D) gContext;
        if (boids!=null){
          //System.out.println(boids.size());
            double r;
            for(int i=0;i<boids.size();i++){ 
                r=boids.get(i).getR();
                if (boids.get(i).getType()==1){//zwykły
                    //g2d.setColor(Color.black);
                    if (mainBoids.mainWin.czyWplywLeader()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorLeadB()));
                    }else if(mainBoids.mainWin.czyAccelWart()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorAccelB()));
                    }else if(mainBoids.mainWin.czyVelWart()){
                    g2d.setColor(Color.getHSBColor(0, 0, boids.get(i).getColorVelB()));
                    }else{ g2d.setColor(Color.black);}
                }else if(boids.get(i).getType()==0){//leader
                    g2d.setColor(Color.blue);
                }else if(boids.get(i).getType()==2) {//przeciwnik
                    g2d.setColor(Color.red);
                }
                
                Ellipse2D circle = new Ellipse2D.Double( boids.get(i).getX(), boids.get(i).getY(), r,r);
                g2d.fill(circle);
                g2d.draw(circle);
                
            } 
            
        }
       
        
        if (obs!=null || !obs.isEmpty()){
            for(int i=0;i<obs.size();i++){
               g2d.setColor(Color.PINK); 
               Ellipse2D circle = new Ellipse2D.Double(obs.get(i).getX(), obs.get(i).getY(), obs.get(i).getR(),obs.get(i).getR());
               g2d.fill(circle);
               g2d.draw(circle);
            }
        }
        
        if (aimX>=0 &&aimY>=0){
        Ellipse2D circle = new Ellipse2D.Double(aimX, aimY, 10,10);
        g2d.setColor(Color.PINK);
        g2d.fill(circle);
        g2d.draw(circle);
        }
        
        }
    public void drawAim( Graphics2D g2d,int x,int y,int r){
        
        
    }    
}  
    
    
