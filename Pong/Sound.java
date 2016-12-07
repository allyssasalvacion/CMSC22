package pong;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by Allyssa Albores on 25/10/2016.
 */

public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}
