import javax.swing.JFrame;

public class App extends JFrame{
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        GamePanel panel = new GamePanel();
        frame.setSize(800, 600);
    /*  frame.setLocationRelativeTo(null); */
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
