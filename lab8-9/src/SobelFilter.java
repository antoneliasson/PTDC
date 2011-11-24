import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** SobelFilter beskriver ett konturförstärkningsfilter */
public class SobelFilter extends ImageFilter {
	private static short[][] X_SOBEL = {
		{-1, 0, 1},
		{-2, 0, 2},
		{-1, 0, 1}
	};
	private static short[][] Y_SOBEL = {
		{-1, -2, -1},
		{0, 0, 0},
		{1, 2, 1}
	};
	
	/** skapa ett filterobjekt med namnet name */
	public SobelFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		// skapa en intensitetsmatris och falta varje punkt i den med X_SOBEL och Y_SOBEL
		short[][] intensities = computeIntensity(inPixels);
		for (int y = 1; y < height-1; ++y) {
			for (int x = 1; x < width-1; ++x) {
				short sx = convolve(intensities, y, x, X_SOBEL, 1);
				short sy = convolve(intensities, y, x, Y_SOBEL, 1);
				if (Math.abs(sx) + Math.abs(sy) > paramValue) {
					outPixels[y][x] = Color.WHITE;
				} else {
					outPixels[y][x] = Color.BLACK;
				}
			}
		}
		
		// fyll de pixlar i outPixels som inte ingick i sobelfiltreringen med vit färg 
		for (int x = 0; x < width; x++) { // översta raden
			outPixels[0][x] = Color.WHITE;
		}
		for (int x = 0; x < width; x++) { // understa raden
			outPixels[height-1][x] = Color.WHITE;
		}
		for (int y = 1; y < height-1; y++) { // de återstående pixlarna i kolumnen längst till vänster
			outPixels[y][0] = Color.WHITE;
		}
		for (int y = 1; y < height-1; y++) { // de återstående pixlarna i kolumnen längst till vänster
			outPixels[y][width-1] = Color.WHITE;
		}
		
		return outPixels;
	}
}
