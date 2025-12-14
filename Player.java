
import java.awt.*;

public class Player {
    int x, y;
    int width = 40;
    int height = 40;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}
