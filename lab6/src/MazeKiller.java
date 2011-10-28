import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.ptdc.window.SimpleWindow;

public class MazeKiller {
	public static void main(String[] args) {
		System.out.print("Ange labyrintens nummer: ");
		java.util.Scanner scan = new java.util.Scanner(System.in);
		//Maze maze = new Maze(scan.nextInt());
		Maze maze = new Maze(1);
		SimpleWindow w = new SimpleWindow(400, 400, "MazeKiller");
		maze.draw(w);
		MazeTurtle turtle = new MazeTurtle(w, 0, 0);
		turtle.penDown();
		turtle.walk(maze);
	}
}
