import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener {

    Player player;
    ArrayList<Enemy> enemies;
    Timer timer;

	int score = 0;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean gameOver = false;

    public GamePanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);

        player = new Player(280, 330);

        enemies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemies.add(new Enemy(600));
        }

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(16, e -> update());
        timer.start();
    }

    private void update() {
    if (gameOver) {
        return;
    }

    // Increase score every frame
    score++;

    if (leftPressed) {
        player.moveLeft();
    }
    if (rightPressed) {
        player.moveRight(getWidth());
    }

    for (Enemy enemy : enemies) {
        enemy.update(getHeight(), getWidth());

        if (player.getBounds().intersects(enemy.getBounds())) {
            gameOver = true;
            timer.stop();
        }
    }

    repaint();
}


    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    player.draw(g);
    for (Enemy enemy : enemies) {
        enemy.draw(g);
    }

    drawScore(g);

    if (gameOver) {
        drawGameOver(g);
    }
}
	private void drawScore(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 16));
    g.drawString("Score: " + score, 10, 20);
}


    private void drawGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("GAME OVER", 180, 200);
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
    public void keyTyped(KeyEvent e) {}
}
