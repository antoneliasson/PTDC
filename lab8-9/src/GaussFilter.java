import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** GaussFilter beskriver ett konturutjämningsfilter */
public class GaussFilter extends ImageFilter {
	private static short[][] GAUSS_KERNEL = {
		{0, 1, 0},
		{1, 4, 1},
		{0, 1, 0}
	};
	
	/** skapa ett filterobjekt med namnet name */
	public GaussFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		// initiera gausskärnan
		GAUSS_KERNEL[GAUSS_KERNEL.length/2][GAUSS_KERNEL.length/2] = (short) Math.round(paramValue);
		// summera elementen
		int gaussWeight = 0;
		for (int y = 0; y < GAUSS_KERNEL.length; ++y) {
			for (int x = 0; x < GAUSS_KERNEL[0].length; ++x) {
				gaussWeight += GAUSS_KERNEL[y][x];
			}
		}
		
		// lagra värdena hos bildens röda, gröna och blå pixlar i tre separata short-matriser
		short[][] redValues = new short[height][width],
				greenValues = new short[height][width],
				blueValues = new short[height][width];
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				Color pixel = inPixels[y][x];			
				redValues[y][x] = (short) pixel.getRed();
				greenValues[y][x] = (short) pixel.getGreen();
				blueValues[y][x] = (short) pixel.getBlue();
			}
		}
		
		// falta alla inre pixlar i de tre matriserna för sig och lagra resultaten som nya färger i outPixels
		for (int y = 1; y < height-1; ++y) {
			for (int x = 1; x < width-1; ++x) {
				short red = convolve(redValues, y, x, GAUSS_KERNEL, gaussWeight);
				short green = convolve(greenValues, y, x, GAUSS_KERNEL, gaussWeight);
				short blue = convolve(blueValues, y, x, GAUSS_KERNEL, gaussWeight);
				outPixels[y][x] = new Color(red, green, blue);
			}
		}
		
		// kopiera över de pixlar som inte ingick i faltningen till outPixels
		for (int x = 0; x < width; x++) { // översta raden
			Color pixel = inPixels[0][x];
			outPixels[0][x] = new Color(pixel.getRed(), 
									    pixel.getGreen(),
									    pixel.getBlue());
		}
		for (int x = 0; x < width; x++) { // understa raden
			Color pixel = inPixels[height-1][x];
			outPixels[height-1][x] = new Color(pixel.getRed(), 
											   pixel.getGreen(),
											   pixel.getBlue());
		}
		for (int y = 1; y < height-1; y++) { // de återstående pixlarna i kolumnen längst till vänster
			Color pixel = inPixels[y][0];
			outPixels[y][0] = new Color(pixel.getRed(), 
									    pixel.getGreen(),
									    pixel.getBlue());
		}
		for (int y = 1; y < height-1; y++) { // de återstående pixlarna i kolumnen längst till vänster
			Color pixel = inPixels[y][width-1];
			outPixels[y][width-1] = new Color(pixel.getRed(), 
											  pixel.getGreen(),
											  pixel.getBlue());
		}
		
		return outPixels;
	}
}
