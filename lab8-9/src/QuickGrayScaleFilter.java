import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** QuickGrayScaleFilter beskriver ett filter som konverterar bilden till gråskala
 * på ett effektivare sätt än GrayScaleFilter */
public class QuickGrayScaleFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public QuickGrayScaleFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		//long starttime = System.nanoTime();
		
		Color[] grayLevels = new Color[256];
		for (int i = 0; i < 256; i++) {
			grayLevels[i] = new Color(i, i, i);
		}
		short[][] intensities = computeIntensity(inPixels);
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				outPixels[i][j] = grayLevels[intensities[i][j]];
			}
		}
		
		//long endtime = System.nanoTime();
		//System.out.println(endtime - starttime);
		return outPixels;
	}
}
