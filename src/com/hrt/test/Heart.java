package com.hrt.test;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Heart extends JFrame {
	private JPanel panel = new JPanel();
	private JButton button;

	Heart() {
		ImageIcon imageIcon = new ImageIcon("resource/images1.jpeg");
		this.button = new JButton(imageIcon);
		this.panel.add(this.button);
		this.add(this.panel);
		this.button.setMargin(new Insets(0, 0, 0, 0));
		this.button.setBorder(null);
		this.button.setOpaque(false);
		this.setVisible(true);
		this.pack();
		this.button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				Toolkit.getDefaultToolkit().beep();
				ImageIcon imageIcon = new ImageIcon("resource/paint.jpg");
				Heart.this.button.setIcon(imageIcon);
				Timer timer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						Toolkit.getDefaultToolkit().beep();
						ImageIcon imageIcon = new ImageIcon("resource/images1.jpeg");
						Heart.this.button.setIcon(imageIcon);

						try {
							Clip clip = null;
							try {
								URL sounURL = SoundClipTest.class.getClassLoader().getResource("main.wav");

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
				});
				timer.setRepeats(false);
				timer.stop();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException var4_4) {
					var4_4.printStackTrace();
				}
				timer.start();
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent) {
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent) {
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent) {
			}

		});
	}

	public static void main(String[] arrstring) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Heart();
			}
		});
	}

}