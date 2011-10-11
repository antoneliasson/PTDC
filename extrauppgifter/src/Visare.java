import se.lth.cs.ptdc.window.SimpleWindow;

/** Klass som representerar en visare till klockan i projektet
 * Klocka.
 * @author anton
 *
 */
public class Visare {
	private SimpleWindow w;
	private java.awt.Color color;
	private int Xcenter, // fönstrets mittpunkt
				Ycenter,
				length, // visarens längd
				max, // max-värdet (60 för minuter och sekunder, 12 för timmar)
				value; // value är internt 0-360 men presenteras som 0-60 utåt
	
	/** Skapar en visare som ritas i fönstret w.
	 * 
	 * @param w
	 * @param value
	 */
	public Visare(SimpleWindow w, java.awt.Color color, int Xcenter, int Ycenter, int length, int max, int value) {
		this.w = w;
		this.color = color;
		this.Xcenter = Xcenter;
		this.Ycenter = Ycenter;
		this.length = length;
		this.max = max;
		setValue(value);
	}
	
	public void draw() {
		double angle = Math.toRadians(90) - Math.toRadians(value);
		int x = Xcenter + (int) Math.round(length * Math.cos(angle));
		int y = Ycenter - (int) Math.round(length * Math.sin(angle));
		
		java.awt.Color previousColor = w.getLineColor();
		w.setLineColor(color);
		w.moveTo(Xcenter, Ycenter);
		w.lineTo(x, y);
		w.setLineColor(previousColor);
	}
	
	public int getValue() {
		return value / (360 / max);
	}
	public void setValue(int value) {
		this.value = value * (360 / max);
	}
	/** Ökar värdet med ett externt men sex internt.
	 * Returnerar true vid överslag, annars false */
	public boolean increment() {
		value += 360 / max;
		if (value >= 360) {
			value -=360;
			return true;
		} else {
			return false;
		}
	}
}
