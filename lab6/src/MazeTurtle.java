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
		
		System.out.println(maze.wallAtLeft(maze.getXEntry(), maze.getYEntry(), 90));
		System.out.println(maze.wallInFront(maze.getXEntry(), maze.getYEntry(), 180));
		jumpTo(maze.getXEntry(), maze.getYEntry());
		
		
		/*
		while(!maze.atExit(getX(), getY())) {
			if (!maze.wallAtLeft(getX(), getY(), getDirection())) {
				left(90);
			}
			if (maze.wallInFront(getX(), getY(), getDirection())) {
				left(-90);
			}
			forward(1);
			SimpleWindow.delay(20);
		}
		*/
		while(!maze.atExit(getX(), getY())) {
			if (maze.wallAtLeft(getX(), getY(), getDirection())) {
				if(maze.wallInFront(getX(), getY(), getDirection())) {
					left(-90);
					forward(1);
				} else {
					forward(1);
				}
			} else {
				left(90);
				forward(1);
			}
			SimpleWindow.delay(20);
		}
		
		
		
	}
}
