import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

public class MazeTurtle extends Turtle {
	public MazeTurtle(SimpleWindow w, int x, int y) {
		super(w, x, y);
	}
	
	/** Låter sköldpaddan vandra genom labyrinten maze, från
	 * ingången till utgången
	 * @param maze
	 */
	public void walk(Maze maze) {
		while(!maze.atExit(getX(), getY())) {
			if (!maze.wallAtLeft(getDirection(), getX(), getY())) {
				left(90);
			}
			if (maze.wallInFront(getDirection(), getX(), getY())) {
				left(-90);
			}
			forward(1);
			SimpleWindow.delay(5);
		}
	}
}
