
import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Dodger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
