import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Triangle extends Shape {
	public int side;

	public Triangle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	
	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side/2, y - (int) Math.round(Math.sqrt(3) * side / 2));
		w.lineTo(x + side, y);
		w.lineTo(x, y);
	}
}
