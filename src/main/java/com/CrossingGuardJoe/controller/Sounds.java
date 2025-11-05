package com.CrossingGuardJoe.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Sounds {
    private final Clip sound;

    public enum SFX {
        MENUBGM, GAMEBGM, CUSTOMIZEBGM, INSTRUCTIONSBGM,
        SELECT, ENTER, FLIPPAGE,
        LEVELUP, JOEPASS1, JOEPASS2, JOESTOP, JOEHIT, KIDWALK1, KIDSTOP1, KIDSTOP2, KIDHIT, KIDSCORE, CARBREAK,
        GAMEOVER, VICTORYBGM;
    }

    public Sounds(String sound) {
        this.sound = loadSound(sound);
    }

    private Clip loadSound(String soundPath) {
        try {
            InputStream rawStream = getClass().getResourceAsStream(soundPath);
            if (rawStream == null) {
                throw new IOException("Sound file not found: " + soundPath);
            }

            try (BufferedInputStream bufferedStream = new BufferedInputStream(rawStream);
                 AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedStream)) {

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                return clip;
            }

        } catch (Exception e) {
            System.err.println("Failed to load sound: " + soundPath);
            e.printStackTrace();
            return null;
        }
    }

    public void play(float volume) {
        if (!sound.isRunning()) {
            setVolume(sound, volume);
            sound.setFramePosition(0);
            sound.start();
        }
    }

    public void pause() {
        sound.stop();
    }

    public void stop() {
        sound.setFramePosition(0);
        sound.stop();
    }

    public void loop(float volume) {
        setVolume(sound, volume);
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void setVolume(Clip clip, float volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }
}
