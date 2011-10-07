import se.lth.cs.ptdc.window.SimpleWindow;

public class ColorTurtle extends Turtle {
	private java.awt.Color color;
	
	public ColorTurtle(SimpleWindow w, int x, int y, java.awt.Color color) {
		super(w, x, y);
		this.color = color;
	}
	
	public void forward(int n) {
		java.awt.Color savedColor = w.getLineColor();
		w.setLineColor(color);
		super.forward(n);
		w.setLineColor(savedColor);
	}
}
