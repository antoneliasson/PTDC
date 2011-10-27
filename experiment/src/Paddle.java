import se.lth.cs.ptdc.window.SimpleWindow;

/** Representerar Breakout-spelets racket
 * 
 * @author anton
 *
 */
public class Paddle {
	private SimpleWindow window;
	private int x;
	private int y;
	private int width;
	
	public Paddle(SimpleWindow window, int x, int y, int width) {
		this.window = window;
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public void move(int x) {
		draw(true); // suddar bort det gamla racket
		this.x += x;
		draw(false); // ritar det nya
	}
	
	/** Ritar racket i fönstret.
	 * 
	 * @param erase
	 * Anger om en svart (false) eller en vit (true) racket ska ritas.
	 */
	public void draw(boolean erase) {
		java.awt.Color previousLineColor = window.getLineColor();
		window.setLineColor(erase ? java.awt.Color.WHITE : java.awt.Color.BLACK);
		window.setLineWidth(10);
		window.moveTo((int)x - width/2, (int)y);
		window.lineTo((int)x + width/2, (int)y);
		window.setLineColor(previousLineColor);
	}
}
