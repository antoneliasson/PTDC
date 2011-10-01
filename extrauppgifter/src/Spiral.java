import se.lth.cs.ptdc.window.SimpleWindow;

public class Spiral {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "Spiral");
		int x0 = w.getWidth() / 2;
		int y0 = w.getHeight() / 2;
		double radius = Math.min(x0, y0) - 20;
		w.moveTo((int)(x0 + radius), y0);
		for (int i = 0; i <= 720; ++i) {
			double angle = Math.toRadians(i);
			int x = x0 + (int) Math.round(radius * Math.cos(angle));
			int y = y0 - (int) Math.round(radius * Math.sin(angle));
			w.lineTo(x, y);
			radius -= 0.25;
		}
	}
}
