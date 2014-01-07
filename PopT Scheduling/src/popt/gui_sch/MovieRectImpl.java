package popt.gui_sch;

import java.awt.Color;

public class MovieRectImpl implements MovieRect{
	private int length, width;
	private Color color;
	private int minX, minY;

	public int area() {
		return length * width;
	}

	public void print() {
		System.out.println("Rectangle " + length + " x " + width);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int l) {
		if (l >= 0)
			this.length = l;
		else
			System.out.println("Negative length!");
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		if (w >= 0)
			this.width = w;
		else
			System.out.println("Negative width!");
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}
}
