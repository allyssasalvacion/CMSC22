package pong;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Allyssa Albores on 25/10/2016.
 */
public class Racquet {
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Game game;

    public Racquet(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = game.speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }


}