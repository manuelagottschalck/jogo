import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Menu extends JPanel {

    public Menu(App frame) {

        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_1) {

                    frame.setContentPane(new GamePanel(1)); //troca o conteudo do frame pro GamePanel
                    frame.revalidate(); //swing reorganiza os componentes do frame

                }

                if (e.getKeyCode() == KeyEvent.VK_2) {

                    frame.setContentPane(new GamePanel(2));
                    frame.revalidate();

                }

                if (e.getKeyCode() == KeyEvent.VK_3) {

                    frame.setContentPane(new GamePanel(3));
                    frame.revalidate();

                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawString("ESCOLHA A FASE", 300, 100);
        g.drawString("1 - FACIL", 300, 150);
        g.drawString("2 - MEDIO", 300, 200);
        g.drawString("3 - DIFICIL", 300, 250);
    }
}