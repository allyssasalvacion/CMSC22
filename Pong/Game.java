package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Allyssa Albores on 25/10/2016.
 */
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    Racquet2 racquet2 = new Racquet2(this);
    //to increase the speed of the sprites
    int speed = 1;
    int speed1 = 0;
    int play = 0;

    private int getScore() {
        return speed - 1;
    }

    private int getScore1() {
        return speed1 - 1;
    }

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
                racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
                racquet2.keyPressed(e);
            }
        });
        setFocusable(true);
        Sound.BACK.loop();
    }

    private void move() {
        //the sprites
        ball.move();
        racquet.move();
        racquet2.move();
    }

    public void paint(Graphics g) {
        //creating the ball & making it move (repainting)
        super.paint(g); //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);             //makes the borders of the ball smoother
        g2d.setColor(Color.DARK_GRAY);
        ball.paint(g2d);
        racquet.paint(g2d);
        racquet2.paint(g2d);

        //display the scores in the window
        //player 2
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 310);
        //player 1
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore1()), 10, 70);
    }

    //The game ends if a player already has 3 points but if neither of them fail to catch the ball, the game continues until the ball drops
    public void gameOver() {
        Sound.BACK.stop();
        //Sound.GAMEOVER.play();
        if(getScore() >= 3 || getScore1() >= 3) {
            Sound.GAMEOVER.play();
            if(getScore() >= 3 && (getScore1() < getScore())) {
                JOptionPane.showMessageDialog(this, "Player 2 Won. Score: " + getScore(),
                        "Game Over", JOptionPane.YES_NO_OPTION);
                play = JOptionPane.showConfirmDialog(null, "Play again?", "", JOptionPane.YES_NO_OPTION);
                if(play == 1) {
                    System.exit(ABORT);
                } else { //to reset the game
                    speed = 1;
                    speed1 = 1;
                }
            } else if(getScore1() >= 3 && (getScore1() > getScore())){
                JOptionPane.showMessageDialog(this, "Player 1 Won. Score: " + getScore1(),
                        "Game Over", JOptionPane.YES_NO_OPTION);
                play = JOptionPane.showConfirmDialog(null, "Play again?", "", JOptionPane.YES_NO_OPTION);
                if(play == 1) {
                    System.exit(ABORT);
                } else {
                    speed = 1;
                    speed1 = 1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "It's A Draw. Score: " + getScore1(),
                        "Game Over", JOptionPane.YES_NO_OPTION);
                play = JOptionPane.showConfirmDialog(null, "Play again?", "", JOptionPane.YES_NO_OPTION);
                if(play == 1) {
                    System.exit(ABORT);
                } else {
                    speed = 1;
                    speed1 = 1;
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        //creating the window
        JFrame frame = new JFrame("Mini Table Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //game loop
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
