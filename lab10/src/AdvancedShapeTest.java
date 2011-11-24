import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedShapeTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "AdvancedShapeTest");
		java.util.Scanner scanner = null;
		try {
			scanner = new java.util.Scanner(new java.io.File("shapedata.txt"));
		} catch (java.io.FileNotFoundException e) {
			System.err.println("shapedata.txt kunde inte öppnas!");
		}
		
		AdvancedShapeList shapes = new AdvancedShapeList();
		if (scanner != null) {
			while (scanner.hasNext()) {
				String type = scanner.next();
				if (type.equals("S")) {
					System.out.println("hittade square!");
					shapes.insert(new AdvancedSquare(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} /*else if (type.equals("T")) { // orkar inte...
					shapes.insert(new Triangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} */else if (type.equals("C")) {
					shapes.insert(new AdvancedCircle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} else {
					System.err.println("hittade skrot i filen!");
					scanner.nextLine(); // skrota raden
				}
			}
		} else { // fallback
			shapes.insert(new AdvancedSquare(10, 300, 150));
			//shapes.insert(new AdvancedTriangle(200, 400, 100));
			shapes.insert(new AdvancedCircle(100, 400, 50));
			shapes.insert(new AdvancedSquare(450, 450, 50));
			shapes.insert(new AdvancedSquare(200, 100, 75));
		}
		
		shapes.draw(w);
		
		AdvancedCommandDispatcher dispatcher = new AdvancedCommandDispatcher(w, shapes);
		dispatcher.mainLoop();
	}
}
