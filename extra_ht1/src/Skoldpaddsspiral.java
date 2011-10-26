import se.lth.cs.ptdc.window.SimpleWindow;

public class Skoldpaddsspiral {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 450, 300);

		t.penDown();
		for (int i = 0; i < 90; i++) {
			t.forward(i/2);
			t.left(15);
		}
	}
}
