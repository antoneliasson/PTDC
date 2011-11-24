import se.lth.cs.ptdc.window.SimpleWindow;

public class ShapeTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		java.util.Scanner scanner = null;
		try {
			scanner = new java.util.Scanner(new java.io.File("shapedata.txt"));
		} catch (java.io.FileNotFoundException e) {
			System.err.println("shapedata.txt kunde inte öppnas!");
		}

		ShapeList shapes = new ShapeList();
		if (scanner != null) {
			while (scanner.hasNext()) {
				String type = scanner.next();
				if (type.equals("S")) {
					shapes.insert(new Square(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} else if (type.equals("T")) {
					shapes.insert(new Triangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} else if (type.equals("C")) {
					shapes.insert(new Circle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				} else {
					System.err.println("hittade skrot i filen!");
					scanner.nextLine(); // skrota raden
				}
			}
		} else { // fallback
			shapes.insert(new Square(10, 300, 150));
			shapes.insert(new Triangle(200, 400, 100));
			shapes.insert(new Circle(100, 400, 50));
			shapes.insert(new Square(450, 450, 50));
			shapes.insert(new Square(200, 100, 75));
		}
		
		shapes.draw(w);
		
		CommandDispatcher dispatcher = new CommandDispatcher(w, shapes);
		//AdvancedCommandDispatcher dispatcher = new AdvancedCommandDispatcher(w, shapes);
		dispatcher.mainLoop();
	}
}
