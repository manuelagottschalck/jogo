import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

    //estrutura base dos poligonos criados

    public class Obstacle {
        int x1 = 500, x2 = 550, x3 = 600;
        int[] xPoints = {x1, x2, x3}; //related to x
        int[] yPoints = {400, 250, 400};

        public void createPolygon(Graphics g){
            
            Graphics2D g2d = (Graphics2D) g;
            int[] xPoints = {x1, x2, x3}; //related to x
            g2d.setColor(Color.RED);
            g2d.fillPolygon(xPoints, yPoints, 3);
        }

        public Polygon getPolygon(){
            int[] xPoints = {x1, x2, x3};
            return new Polygon(xPoints, yPoints, 3);
         }
    }