import se.lth.cs.ptdc.window.SimpleWindow;

/** Representerar en boll i ett SimpleWindow-fönster. Håller koll på
 * läge, riktning och storlek.
 * @author anton
 *
 */
public class Ball {
	private SimpleWindow window;
	private double x;
	private double y;
	private double direction;
	private int size;
	
	public Ball(SimpleWindow window, double x, double y, double direction, int size) {
		this.window = window;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.size = size;
	}
	
	/** Flyttar bollen steps steg i aktuell riktning
	 * 
	 * @param steps
	 */
	public void move(int steps) {
		draw(true); // sudda bort den gamla bollen
		
		x += Math.cos(Math.toRadians(direction)) * steps;
		y -= Math.sin(Math.toRadians(direction)) * steps;
		
		if (x + size/2 >= window.getWidth() || x - size/2 <= 0) {
			direction = 180 - direction;
		}
		if (y + size/2 >= window.getHeight() || y - size/2 <= 0) {
			direction = -direction;
		}
		
		draw(false);
	}
	
	/** Ritar bollen i fönstret. Beroende på parametern erase ritas en svart (false)
	 * eller en vit (true) boll.
	 * @param erase
	 */
	public void draw(boolean erase) {
		java.awt.Color previousLineColor = window.getLineColor();
		window.setLineColor(erase ? java.awt.Color.WHITE : java.awt.Color.BLACK);
		window.setLineWidth(size);
		window.moveTo((int)x - size/2, (int)y);
		window.lineTo((int)x + size/2, (int)y);
		window.setLineColor(previousLineColor);
	}
}
