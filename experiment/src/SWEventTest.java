import se.lth.cs.ptdc.window.SimpleWindow;

// Tänkte testa hur event i SimpleWindow fungerar.
public class SWEventTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(300, 300, "");
		w.waitForEvent();
		while (true) {
			System.out.println(w.getKey());
			SimpleWindow.delay(1000);
		}
	}
}
// Resultat: Dåligt.