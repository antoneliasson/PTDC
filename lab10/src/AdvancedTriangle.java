import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedTriangle extends AdvancedShape {
	public int side;

	public AdvancedTriangle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	
	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side/2, y - (int) Math.round(Math.sqrt(3) * side / 2));
		w.lineTo(x + side, y);
		w.lineTo(x, y);
	}

	public boolean contains(int x, int y) {
		boolean expr1 = y < this.y,
			expr2 = x < 1 / Math.sqrt(3) * y - 1 / Math.sqrt(3) * this.y + side + this.x,
			expr3 = x > -1 / Math.sqrt(3) * y + 1 / Math.sqrt(3) * this.y + this.x;
			//expr2 = x < 1 / Math.sqrt(3) * y - 1 / Math.sqrt(3) * this.y + this.x,
			//expr3 = x > -1 / Math.sqrt(3) * y + 1 / Math.sqrt(3) * this.y + this.x;
		System.out.println("expr1=" + expr1 + "\texpr2=" + expr2 + "\texpr3=" + expr3);
		return expr1 && expr2 && expr3;
	}
}
