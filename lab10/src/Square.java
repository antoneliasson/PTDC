import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class Square extends Shape {
	public int side;
	
	public Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	
	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side, y);
		w.lineTo(x + side, y + side);
		w.lineTo(x, y + side);
		w.lineTo(x, y);
	}
}
