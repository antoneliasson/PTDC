import se.lth.cs.ptdc.window.SimpleWindow;

public class Teckentabell {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "Teckentabell");
		for (int x = 2; x < 16; x++) {
			if (x > 7 && x < 12) {
				continue; // tihi
			}
			for (int y = 0; y < 16; y++) {
				char current = (char) (16*x + y);
				w.moveTo(16*x+16, 16*y+16);
				w.writeText(new String()+current);
			}
		}
	}
}
