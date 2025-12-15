
import java.awt.*;
import java.util.Random;

public class Enemy {

    int x, y;
    int width = 40;
    int height = 40;
    int speed = 4;

    static Random random = new Random();

    public Enemy(int panelWidth) {
        reset(panelWidth);
        y = -random.nextInt(300);
    }

    public void update(int panelHeight, int panelWidth) {
        y += speed;
        if (y > panelHeight) {
            reset(panelWidth);
        }
    }

    private void reset(int panelWidth) {
        x = random.nextInt(panelWidth - width);
        y = -height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}

