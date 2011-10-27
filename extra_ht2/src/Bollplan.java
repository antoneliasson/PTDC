import se.lth.cs.ptdc.window.SimpleWindow;

public class Bollplan {
	public static void main(String[] args) {
		SimpleWindow window = new SimpleWindow(400, 400, "Bollplan");
		Ball kuben = new Ball(window, 100, 100, 15, 10); // random, random
		
		while(true) {
			kuben.move(1);
			SimpleWindow.delay(10);
		}
	}
}
