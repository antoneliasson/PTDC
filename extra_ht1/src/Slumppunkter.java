import se.lth.cs.ptdc.window.SimpleWindow;

public class Slumppunkter {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(300, 300, "Slumppunkter");
		java.util.Random rand = new java.util.Random();
		int randX, randY;
		for (int i = 0; i < 10000; i++) {
			randX = rand.nextInt(300);
			randY = rand.nextInt(300);
			w.moveTo(randX, randY);
			w.lineTo(randX, randY);
		}
	}
}
