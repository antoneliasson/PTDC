import se.lth.cs.ptdc.window.SimpleWindow;

public class TwoTurtles {
	public static void main(String[] args) {
		java.util.Random rand = new java.util.Random();
		SimpleWindow w = new SimpleWindow(600, 600, "MarathonTurtle");
		Turtle torchic = new Turtle(w, 250, 250), mudkip = new Turtle(w, 350, 350);
		torchic.penDown();
		mudkip.penDown();
		while (Math.hypot(torchic.getX()-mudkip.getX(), torchic.getY()-mudkip.getY()) >= 100) {
			torchic.forward(rand.nextInt(10));
			torchic.left(rand.nextInt(360) - 180);
			
			mudkip.forward(rand.nextInt(10));
			mudkip.left(rand.nextInt(360) - 180);
			SimpleWindow.delay(50);
		}
	}
}
