package thor.thor.character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The character to play with, Thor.
 */
public class Thor {

    private final int x;
    private int y;

    public Thor(int x, int y) {
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
        this.y -= 10;
    }

    public void gravityMove() {
        this.y += 10;
    }

    public boolean hitTheGround() {
        if (this.y == 500) {
            return true;
        }

        return false;
    }

    public Rectangle getBorders() {
        return new Rectangle(getX(), getY(), 10, 10);
    }

    public void draw(Graphics g) {

        //CAPE
        g.setColor(Color.red);
        g.fillRect(this.x - 4, this.y + 5, 34, 5);

        //BODY
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x, this.y + 10, 30, 15);
        g.fillRect(this.x - 10, this.y + 12, 45, 10);

        //HEAD
        g.setColor(Color.YELLOW);
        g.fillRect(this.x + 30, this.y + 10, 15, 15);

        //HAND
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x + 30, this.y + 13, 25, 8);

        //MJÖLNIR
        g.setColor(new Color(102, 51, 0));
        g.fillRect(this.x + 45, this.y, 5, 20);
        g.setColor(Color.GRAY);
        g.fillRect(this.x + 40, this.y - 10, 15, 10);
    }

}
