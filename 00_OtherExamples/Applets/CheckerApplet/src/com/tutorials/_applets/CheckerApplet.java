package com.tutorials._applets;

import java.applet.*;
import java.awt.*;

public class CheckerApplet extends Applet {
	private static final long serialVersionUID = 1L;
	int squareSize = 50;

	public void init () {
		String squareSizeParam = this.getParameter("squareSize");
		parseSquareSize(squareSizeParam);
		String colorParam = getParameter ("color");
		Color fg = parseColor(colorParam);
		this.setBackground(Color.GREEN);
		this.setForeground(fg);
	}

	private void parseSquareSize(String param) {
		if (param == null) {
			return;
		}

		try {
			squareSize = Integer.parseInt(param);
		}
		catch (Exception e) {
			// Let default value remain
		}
	}

	private Color parseColor(String param) {
		if (param == null) {
			return Color.BLACK;
		}

		try {
			return Color.BLUE;
		}
		catch (Exception e) {}
		
		return Color.WHITE;
	}

	public void paint (Graphics g) {}
}
