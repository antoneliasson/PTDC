import java.util.Random;
import se.lth.cs.ptdc.window.SimpleWindow;

/** Klass som ordnar ett lopp mellan två sköldpaddor */
public class RacingEvent {
	private RaceTrack track;
	private Turtle t1;
	private Turtle t2;
	
	/** Skapar ett lopp mellan sköldpaddorna t1 och t2 på
	kapplöpningsbanan track */
	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
	}
	
	/** Väntar på ett musklick från användaren och genomför sedan ett lopp
	 * mellan de tävlande sköldpaddorna som angavs i konstruktorn i fönstret w.
	 * Vinnaren returneras. */
	public Turtle race(SimpleWindow w) {
		w.waitForMouseClick();
		
		Random rand = new Random();
		
		// de tävlande ställer sig i startgroparna
		t1.penDown();
		t2.penDown();
		
		// fortsätt loppet så länge ingen har passerat mållinjen
		while (t1.getY() >= track.getFinish() && t2.getY() >= track.getFinish()) {
			t1.forward(rand.nextInt(3));
			t2.forward(rand.nextInt(3));
			SimpleWindow.delay(20);
		}
		
		// vi vet nu att en har vunnit, ta reda på vilken
		if (t1.getY() < track.getFinish()) {
			return t1;
		} else {
			return t2;
		}
	}
}
