import se.lth.cs.ptdc.window.SimpleWindow;

public class Bollplan {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "Bollplan");
		Boll kuben = new Boll(w, 100, 200, 30); // random, random
		
		while(true) {
			kuben.step(1);
			kuben.draw();
			SimpleWindow.delay(10);
		}
	}
}
