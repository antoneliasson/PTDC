import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.ptdc.window.SimpleWindow;

public class CommandDispatcher {
	private SimpleWindow w;
	private ShapeList shapes;
	
	public CommandDispatcher(SimpleWindow w, ShapeList shapes) {
		this.w = w;
		this.shapes = shapes;
	}
	
	public void mainLoop() {
		while (true) {
			w.waitForMouseClick();
			Shape selectedShape = shapes.findHit(w.getMouseX(), w.getMouseY());
			if (selectedShape != null) {
				System.out.println("markerad!");
				w.waitForMouseClick();
				selectedShape.moveToAndDraw(w, w.getMouseX(), w.getMouseY());
			}
		}
	}
}
