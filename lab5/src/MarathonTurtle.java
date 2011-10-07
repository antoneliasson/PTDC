import se.lth.cs.ptdc.window.SimpleWindow;

public class MarathonTurtle {
	public static void main(String[] args) {
		java.util.Random rand = new java.util.Random();
		SimpleWindow w = new SimpleWindow(600, 600, "MarathonTurtle");
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(rand.nextInt(10));
			//SimpleWindow.delay(10);
			t.left(rand.nextInt(360) - 180);
		}
	}
}
