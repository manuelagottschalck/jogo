import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
    // Graphics g;
    private static final int SQUARE_SIZE = 100;
    private static final int SPEED = 1;
    private int squarex = 0;

    public GamePanel(){
        Timer timer = new Timer(10, e -> {
           updatingGame();
        });

        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int y = (getWidth() - SQUARE_SIZE) / 2;
        g2d.fillRect(squarex, y, SQUARE_SIZE, SQUARE_SIZE);
        Toolkit.getDefaultToolkit().sync();
        this.updatingGame();
    }

    public void updatingGame(){
        int bottomLimit = getWidth() - SQUARE_SIZE;

        squarex += SPEED;

        if (squarex <= 0) {
            squarex = 0;
        } else if (squarex >= bottomLimit) {
            squarex = bottomLimit;
        }

        repaint();
    }
    
}
