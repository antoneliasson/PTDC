import se.lth.cs.ptdc.window.SimpleWindow;

public class Monster {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(300, 600, "Mönster");
		for (int i = 0; i < 600; i++) {
			w.moveTo(0, i);
			double radians = Math.toRadians(i*2);
			double sinus = Math.sin(radians);
			int colorValue = (int) (255 * Math.abs(sinus));
			w.setLineColor(new java.awt.Color(colorValue, colorValue, colorValue));
			w.lineTo(300, i);
		}
	}
}
