package pong;

import java.awt.*;

/**
 * Created by Allyssa Albores on 25/10/2016.
 */
public class Ball {
    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    //represents the speed in which the ball is moving
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        boolean changeDirection = true;
        if (x + xa < 0) {                     //left border
            xa = game.speed;
        } else if (x + xa > game.getWidth() - DIAMETER) {  //right border
            xa = -game.speed;
        } else if (y + ya <= 0) {                           //top border
            ya = game.speed;
            game.gameOver();
        } else if (y + ya > game.getHeight() - DIAMETER) {    //bottom border
            ya = -game.speed;
            game.gameOver();
        } else if (collision()){
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        } else if (collision2()){
            ya = game.speed;
            y = game.racquet2.getTopY() - DIAMETER;
            game.speed1++;
        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            Sound.BALL.play();
        }



        x = x + xa;
        y = y + ya;
    }

    //returns true, if the rectangle occupied by the racquet intersects with the rectangle occupied by the ball
    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    private boolean collision2() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
