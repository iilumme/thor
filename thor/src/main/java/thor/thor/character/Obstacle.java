package thor.thor.character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The model of the obstacle.
 */

public class Obstacle {

    private int x;
    private final int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move() {
        this.x -= 1;
    }

    public Rectangle getBorders() {
        return new Rectangle(getX(), getY(), 10, 10);
    }

    public void draw(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(this.x+1, this.y+1, 48, 48);
        
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, 50, 50);
    }

}
