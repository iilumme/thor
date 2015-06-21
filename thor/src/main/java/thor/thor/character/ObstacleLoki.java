package thor.thor.character;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ObstacleLoki extends Obstacle {

    private final ImageIcon imageicon;

    public ObstacleLoki(int x, int y) {
        super(x, y);
        this.imageicon = new ImageIcon(ClassLoader.getSystemResource("Images/loki.jpeg"), "loki.jpeg");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.imageicon.getImage(), super.getX(), super.getY(), null);
    }

}
