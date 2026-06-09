import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

    private static final int GROUND = 150;

    public int phase;
    boolean gameIsOn;

    Player player = new Player();
    Obstacle obstacle = new Obstacle();

    Random random = new Random();
    private long startTime;

    public GamePanel(int phase) {

        this.phase = phase;
        gameIsOn = true;
        startTime = System.currentTimeMillis();

        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                        player.jumping = true;
                        player.velocityY = -15;
                    
                }
            }
        });

        Timer timer = new Timer(10, e -> {
            updatingGame();
        });

        timer.start();
    }

    @Override
    public void addNotify() { //requisitar o foco do panel, quando seto o conteudo do frame, o notify é a primeira coisa a ser chamada
        super.addNotify();
        requestFocusInWindow();
    }

    public int speedPerPhase(int phase) {

        switch (phase) {

            case 1:
                return 6;

            case 2:
                return 8;

            case 3:
                return 10;

            default:
                return 6;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.drawPlayer(g);

        g2d.fillRect(0, getHeight() - GROUND, getWidth(), GROUND);

        obstacle.createPolygon(g2d);

        Polygon p = obstacle.getPolygon();
        g2d.drawPolygon(p);

        long score = (System.currentTimeMillis() - startTime) / 100;

        if(gameIsOn) {
            g.drawString("Pontuação: " + score, 20, 40);    
        }
    }

    public void updatingGame() {

        if (!gameIsOn) {
            repaint();
            return;
        }

        int currentSpeed = speedPerPhase(phase);

        obstacle.x1 -= currentSpeed;
        obstacle.x2 -= currentSpeed;
        obstacle.x3 -= currentSpeed;

        if (obstacle.x3 < 0) {

            int startX = 800 + random.nextInt(400);

            obstacle.x1 = startX;
            obstacle.x2 = startX + 50;
            obstacle.x3 = startX + 100;
        }

        if (player.jumping) {

            player.squarey += player.velocityY;
            player.velocityY += 1;

            if (player.squarey >= 300) {

                player.squarey = 300;
                player.jumping = false;
                player.velocityY = 0;
            }
        }

        Rectangle playerRect =    //quadrado fantasma para detectar colisao com o triangulo
                new Rectangle(
                        player.squarex,
                        player.squarey,
                        100,
                        100);

        if (obstacle.getPolygon().intersects(playerRect)) {
            gameIsOn = false;
        }

        repaint();
    }
}
