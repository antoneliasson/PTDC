import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** GrayScaleFilter beskriver ett filter som konverterar bilden till gråskala */
public class GrayScaleFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public GrayScaleFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		//long starttime = System.nanoTime();

		short[][] intensities = computeIntensity(inPixels);
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				outPixels[i][j] = new Color(intensities[i][j],
						intensities[i][j],
						intensities[i][j]);
			}
		}
		
		//long endtime = System.nanoTime();
		//System.out.println(endtime - starttime);
		return outPixels;
	}
}
