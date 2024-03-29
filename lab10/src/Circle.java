import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int x, int y, int radius) {
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
}
