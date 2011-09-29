import se.lth.cs.ptdc.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w; // fönstret sköldpaddan befinner sig i
	private double x; // nuvarande x-koordinat
	private double y; // nuvarande y-koordinat
	private int orientation = 270; // nuvarande orientering i grader, räknat motsols med noll rakt österut
	private boolean penEnabled = false;
	
	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning)
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		w.moveTo(x, y);
	}
	
	/** Sänker pennan */
	public void penDown() {
		penEnabled = true;
	}
	
	/** Lyfter pennan */
	public void penUp() {
		penEnabled = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning som huvudet pekar */
	public void forward(int n) {
		x += n * Math.cos(Math.PI * orientation / 180);
		y += n * Math.sin(Math.PI * orientation / 180);
		
		if (penEnabled) {
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		} else {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		}
	}
	
	/** Vrider beta grader åt vänster runt pennan */
	public void left(int beta) {
		orientation -= beta;
		orientation %= 360;
	}
	
	/** Går till punkten newX,newY utan att rita. Pennans läge (sänkt 
	    eller lyft) och huvudets riktning påverkas inte */
	public void jumpTo(int newX, int newY) {
		// ... implementera
	}
	
	/** Återställer huvudriktningen till den ursprungliga */
	public void turnNorth() {
		// ... implementera
	}
	
	/** Tar reda på x-koordinaten för sköldpaddans aktuella position */
	public int getX() {
		// ... implementera
		return 0;
	}
	
	/** Tar reda på y-koordinaten för sköldpaddans aktuella position */
	public int getY() {
		// ... implementera
		return 0;
	}
	
	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
	public int getDirection() {
		// ... implementera
		return 0;
	}
}
