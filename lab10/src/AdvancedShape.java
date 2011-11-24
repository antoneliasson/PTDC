import se.lth.cs.ptdc.shapes.Shape;


public abstract class AdvancedShape extends Shape {
	protected AdvancedShape(int x, int y) {
		super(x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	/**
	 * Kontrollerar om objektet innehåller punkten x, y
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean contains(int x, int y);
}
