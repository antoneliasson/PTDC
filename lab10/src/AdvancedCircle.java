import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedCircle extends AdvancedShape {
	private int radius;
	
	public AdvancedCircle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public void draw(SimpleWindow w) {
		final int CORNERS = 36;
		w.moveTo(x + radius, y);
		double conv = 2 * Math.PI / CORNERS;
		for (int i = 1; i <= CORNERS; i++) {
			double angle = i * conv;
			w.lineTo((int) Math.round(x + radius * Math.cos(angle)),
					(int) Math.round(y + radius * Math.sin(angle)));
		}
	}

	public boolean contains(int x, int y) {
		int dx = x - this.x;
		int dy = y - this.y;
		return dx * dx + dy * dy < radius * radius;
	}
}
