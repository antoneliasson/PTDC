import se.lth.cs.ptdc.window.SimpleWindow;

public class Forbindelser {
	public static void main(String[] args) {
		System.out.print("Ange antal hörn: ");
		java.util.Scanner scan = new java.util.Scanner(System.in); 
		int horn = scan.nextInt();
		java.awt.Point[] punkter = new java.awt.Point[horn];
		
		// Skapa ett fält med alla punkter
		for (int i = 0; i < horn; i++) {
			int vinkel = 360 * i / horn;
			int x = (int) Math.round(Math.cos(Math.toRadians(vinkel)) * 100 + 150);
			int y = (int) Math.round(Math.sin(Math.toRadians(vinkel)) * 100 + 150);
			punkter[i] = new java.awt.Point(x, y);
			System.out.println(x + " " + y);
		}
		
		SimpleWindow window = new SimpleWindow(300, 300, "Förbindelser");
		
		// Rita ut alla punkter
		for (int i = 0; i < punkter.length; i++) {
			for (int j = 0; j < punkter.length; j++) {
				window.moveTo((int) punkter[i].getX(), (int) punkter[i].getY()); // redan avrundat i Point
				window.lineTo((int) punkter[j].getX(), (int) punkter[j].getY());
			}
		}
	}
}
