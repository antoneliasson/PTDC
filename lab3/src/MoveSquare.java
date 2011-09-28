import se.lth.cs.ptdc.window.SimpleWindow;
import se.lth.cs.ptdc.square.Square;

public class MoveSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "MoveSquare");
		Square sq = new Square(300, 300, 100);
		sq.draw(w);
		
		while(true) {
			w.waitForMouseClick();
			sq.erase(w);
			sq.move(w.getMouseX() - sq.getX(), w.getMouseY() - sq.getY());
			//System.out.println("X=" + sq.getX() + ", Y=" + sq.getY());
			sq.draw(w);
		}
	}
}
