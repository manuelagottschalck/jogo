import javax.swing.JFrame;

public class App extends JFrame {

    public App(){

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(new Menu(this));

        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
