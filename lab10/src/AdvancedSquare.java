import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedSquare extends AdvancedShape {
	public int side;
	
	public AdvancedSquare(int x, int y, int side) {
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
	
	public boolean contains(int x, int y) {
		return x > this.x && x < this.x + side && y > this.y && y < this.y + side;
	}
}
