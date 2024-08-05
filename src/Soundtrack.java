package com.codeforall.online.damngame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *  Creates and reproduces a soundtrack
 */
public class Soundtrack {
    private Clip clip = AudioSystem.getClip();
    private AudioInputStream audioInput;

    public Soundtrack()
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.audioInput = AudioSystem.getAudioInputStream(new File("resources/resources/music/castaways.wav"));
    }

    /**
     *  Opens an audio file and reproduces it in an infinite loop
     */
    public void play() throws LineUnavailableException, IOException {
        this.clip.open(this.audioInput);

        this.clip.loop(Clip.LOOP_CONTINUOUSLY);

        this.audioInput.close();
    }
}
