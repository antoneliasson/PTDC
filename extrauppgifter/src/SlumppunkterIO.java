import se.lth.cs.ptdc.window.SimpleWindow;
import java.io.FileInputStream;
import java.io.IOException;

// Hämtar slumpdatan från fil
public class SlumppunkterIO {
	public static void main(String[] args) throws IOException {
		SimpleWindow w = new SimpleWindow(256, 256, "Slumppunkter");
		FileInputStream rand = null;
		int randX, randY;
		
		try { // prova att...
			rand = new FileInputStream("randomness.dat"); // ...öppna filen med slumpdatan
			
			for (int i = 0; i < 10000; i++) {
				// läs en byte till randX och en till randY och fortsätt bara om det gick bra
				if ((randX = rand.read()) != -1 && (randY = rand.read()) != -1) {
					w.moveTo(randX, randY);
					w.lineTo(randX, randY);
				}
			}
		} finally {
			if (rand != null) {
				rand.close();
			}
		}
		
	}
}
