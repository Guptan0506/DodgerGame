import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    Player player;

    public GamePanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);
        player = new Player(280, 330);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}

