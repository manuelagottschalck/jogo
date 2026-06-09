import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player {

    public int squarex = 100;
    public int squarey = 300;

    public boolean jumping = false;

    public int velocityY = 0;

    public void drawPlayer(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(squarex, squarey, 100, 100);
    }
}
