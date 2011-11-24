import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedCommandDispatcher {
	private SimpleWindow w;
	private AdvancedShapeList shapes;
	
	public AdvancedCommandDispatcher(SimpleWindow w, AdvancedShapeList shapes) {
		this.w = w;
		this.shapes = shapes;
	}
	
	public void mainLoop() {
		while (true) {
			w.waitForMouseClick();
			System.out.println("klick!");
			AdvancedShape selectedShape = shapes.figureAt(w.getMouseX(), w.getMouseY());
			if (selectedShape != null) {
				System.out.println("markerad!");
				// ta reda på var i figuren det klickades
				int relX = w.getMouseX() - selectedShape.getX();
				int relY = w.getMouseY() - selectedShape.getY();
				
				w.waitForMouseClick();
				selectedShape.moveToAndDraw(w, w.getMouseX() - relX, w.getMouseY() - relY);
			}
		}
	}
}
