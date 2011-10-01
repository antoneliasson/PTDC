import se.lth.cs.ptdc.window.SimpleWindow;

public class Funktionskurva {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 220, "Funktionskurva");
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Ange maxvärdet på x i grader: ");
		int xMax = scan.nextInt();
		int y = 110;
		w.moveTo(0, y);
		
		for (int x = 0; x < xMax; x++) {
			y = (int) (110 + 100 * Math.sin(Math.toRadians(x)));
			w.lineTo(x, y);
		}
	}
}
