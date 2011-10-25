import se.lth.cs.ptdc.window.SimpleWindow;

/** Klass som ritar upp en kapplöpningsbana */
public class RaceTrack {
	private int yStart;
	private int yFinish;
	
	/** Skapar en kapplöpningsbana. yStart och yFinish är
	y-koordinaterna för start- och mållinje */
	public RaceTrack(int yStart, int yFinish) {
		this.yStart = yStart;
		this.yFinish = yFinish;
	}
	
	/** Ritar kapplöpningsbanan i fönstret w */
	public void draw(SimpleWindow w) {
		// rita startlinje
		w.moveTo(w.getWidth() / 4, yStart);
		w.lineTo(3 * w.getWidth() / 4, yStart);
		// rita mållinje
		w.moveTo(w.getWidth() / 4, yFinish);
		w.lineTo(3 * w.getWidth() / 4, yFinish);
	}
	
	/** Returnerar startlinjens y-värde */
	public int getStart() {
		return yStart;
	}
	
	/** Returnerar mållinjens y-värde */
	public int getFinish() {
		return yFinish;
	}
}
