import java.awt.*;

public class Player {
    int x, y;
    int width = 40;
    int height = 40;
    int speed = 5;   // how fast the player moves

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveRight(int panelWidth) {
        x += speed;
        if (x + width > panelWidth) {
            x = panelWidth - width;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}

