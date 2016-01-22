package com.tutorials._applets;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletExample extends Applet {
	@Override
	public void paint(Graphics g) {
		g.drawString("hello applet", 25, 50);
	}
}
