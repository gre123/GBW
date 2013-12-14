package gui;
import boids.boid;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;
 
public class panel extends JPanel {
    public ArrayList<boid> boids,prey;
    int x,y;
    public panel(ArrayList<boid> _boids, ArrayList<boid> _prey) {
        x=1080;
        y=685;
        setPreferredSize(new Dimension(x, y));
        boids=_boids;
        prey=_prey;     
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
            for(int i=0;i<boids.size();i++){
                double x=boids.get(i).getX();
                double y=boids.get(i).getY();
                double r=boids.get(i).getR();
                if (boids.get(i).getType()==1){//zwykły
                    g2d.setColor(Color.black);
                }else if(boids.get(i).getType()==0){//leader
                    g2d.setColor(Color.blue);
                }else if(boids.get(i).getType()==2) {//przeciwnik
                    g2d.setColor(Color.red);
                }
                
                
                Ellipse2D circle = new Ellipse2D.Double(x, y, r,r);
                g2d.fill(circle);
                g2d.draw(circle);
            } 
            
        }
        if (boids!=null || !prey.isEmpty()){
            for(int i=0;i<prey.size();i++){
               double x=prey.get(i).getX();
               double y=prey.get(i).getY();
               double r=prey.get(i).getR();
               g2d.setColor(Color.gray); 
               
               Ellipse2D circle = new Ellipse2D.Double(x, y, r,r);
               g2d.fill(circle);
               g2d.draw(circle);
                
            }
        }
        
        }
        
}  
    
    
