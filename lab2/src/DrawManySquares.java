import java.util.Scanner;
import se.lth.cs.ptdc.square.Square;
import se.lth.cs.ptdc.window.SimpleWindow;

public class DrawManySquares {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv förminskning");
		int dim = scan.nextInt();
		System.out.println("Skriv rotation");
		int rot = scan.nextInt();
		SimpleWindow w = new SimpleWindow(600, 600, "DrawManySquares");
		Square sq = new Square(300, 300, 200);
		while (sq.getSide() > 0) {
			sq.draw(w);
			sq.setSide(sq.getSide() - dim);
			sq.rotate(rot);
		}
	}
}
