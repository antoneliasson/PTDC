import se.lth.cs.ptdc.window.SimpleWindow;
import java.awt.Color;

public class Farger {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(256, 256, "Färger");
		for (int y = 0; y < 256; y++) {
			for (int x = 0; x < 256; x++) {
				w.moveTo(x, y);
				w.setLineColor(new Color(y, 0, x));
				w.lineTo(x, y);
			}
		}
	}
}
