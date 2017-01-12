package com.design;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PolygonJavaAPITest extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] xpoints = { 0, 200, 0 };
		int[] ypoints = { 0, 0, 200 };
		int npoints = 4;
		Polygon p = new Polygon(xpoints, ypoints, npoints);
		// boolean contains = p.contains(1, 2);
		// System.out.println("HKHR : " + contains);
		// Polygon p = new Polygon();
		/*
		 * for (int i = 0; i < 5; i++) { int x = (int) (100 + 50 * Math.cos(i *
		 * 2 * Math.PI / 5)); int y = (int) (100 + 50 * Math.sin(i * 2 * Math.PI
		 * / 5)); p.addPoint(x, y); System.out.println("x : "+ x + " --- " +
		 * "y : "+ y); }
		 */
		g.drawPolygon(p);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Polygon");
		frame.setSize(350, 250);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = frame.getContentPane();
		contentPane.add(new PolygonJavaAPITest());
		frame.setVisible(true);
	}

}
