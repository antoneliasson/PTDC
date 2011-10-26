import se.lth.cs.ptdc.window.SimpleWindow;

public class BMI {
	private static int calculateNormality(int length, int weight) {
		int BMI = 10000 * weight / length / length;
		return (BMI < 18.5 ? -1 : (BMI > 25 ? 1 : 0));
	}
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(100, 100, "BMI");
		
		for (int weight = 30; weight < 130; weight++) { // y+30
			for (int length = 100; length < 200; length++) { // x+100
				int x = length-100;
				int y = 130-weight;
				w.moveTo(x, y);
				int color = calculateNormality(length, weight);
				w.setLineColor(color < 0 ? java.awt.Color.YELLOW :
					(color > 0 ? java.awt.Color.RED : java.awt.Color.GREEN));
				w.lineTo(x, y);
			}
		}
	}
}
