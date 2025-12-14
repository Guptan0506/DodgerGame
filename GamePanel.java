import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener {

    Player player;
    Timer timer;

    boolean leftPressed = false;
    boolean rightPressed = false;

    public GamePanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);

        player = new Player(280, 330);

        addKeyListener(this);
        setFocusable(true);

        // Game loop: runs every 16ms (~60 FPS)
        timer = new Timer(16, e -> update());
        timer.start();
    }

    private void update() {
        if (leftPressed) {
            player.moveLeft();
        }
        if (rightPressed) {
            player.moveRight(getWidth());
        }
        repaint(); // redraw screen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }

    // Keyboard input
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }
}

