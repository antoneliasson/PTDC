import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** InvertFilter beskriver ett filter som inverterar bilden */
public class InvertFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public InvertFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				Color pixel = inPixels[i][j];			
				outPixels[i][j] = new Color(255 - pixel.getRed(), 
										    255 - pixel.getGreen(),
										    255 - pixel.getBlue());
			}
		}
		return outPixels;
	}
}
