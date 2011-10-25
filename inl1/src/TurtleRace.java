import se.lth.cs.ptdc.window.SimpleWindow;

public class TurtleRace {
	/** Skapar sköldpaddorna, kapplöpningsbanan och ett lopp,
	genomför loppet */
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "TurtleRace");
		RaceTrack track = new RaceTrack(300, 100);
		track.draw(w);
		Turtle t1 = new Turtle(w, w.getWidth() / 3, track.getStart());
		Turtle t2 = new Turtle(w, 2 * w.getWidth() / 3, track.getStart());
		RacingEvent event = new RacingEvent(track, t1, t2);
		
		if (event.race(w) == t1) {
			System.out.println("Sköldpadda 1 vann!");
		} else {
			System.out.println("Sköldpadda 2 vann!");
		}
	}
}
