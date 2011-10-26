import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.square.Square;

public class Kvadrater {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 100, "Kvadrater");
		Square sq = new Square(50, 50, 50);
		sq.draw(w);
		for (int i = 0; i < 9; i++) {
			sq.move(50, 0);
			sq.rotate(10);
			sq.draw(w);
		}
	}
}
