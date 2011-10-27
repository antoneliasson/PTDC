import se.lth.cs.ptdc.window.SimpleWindow;

public class Boll {
	private SimpleWindow w;
	private double x,
				   y,
				   direction;
	
	public Boll(SimpleWindow w, double x, double y, double direction) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void step(int steps) {
		x += Math.cos(Math.toRadians(direction)) * steps;
		y -= Math.sin(Math.toRadians(direction)) * steps;
		
		if (x >= w.getWidth() || x <= 0) {
			direction = 180 - direction;
		} else if (y >= w.getHeight() || y <= 0) {
			direction = -direction;
		}
	}
	
	public void draw() {
		w.clear(); // eller vita en rit boll kanske? ;)
		w.setLineWidth(10);
		w.moveTo((int)x-5, (int)y);
		w.lineTo((int)x+5, (int)y);
	}
}
