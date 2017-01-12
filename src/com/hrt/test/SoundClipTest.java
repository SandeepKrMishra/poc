package com.hrt.test;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClipTest {
	public static void main(String[] args) {
		try {
			Clip clip = null;
	        try {
				URL sounURL = SoundClipTest.class.getClassLoader().getResource("music3.wav");

	            AudioInputStream inputStream = AudioSystem.getAudioInputStream(sounURL);
	            DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
	            clip = (Clip) AudioSystem.getLine(info);
	            clip.open(inputStream);

	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        } catch (UnsupportedAudioFileException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        clip.start();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}