import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** ContrastFilter beskriver ett kontrastökningsfilter */
public class ContrastFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public ContrastFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt värdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		short[][] intensities = computeIntensity(inPixels);
		
		short[] histogram = new short[256];
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				histogram[intensities[i][j]]++;
			}
		}
		
		double cutOff = paramValue / 100;
		//System.out.println("\ncutOff: " + cutOff);
		
		int intensitySum = 0, index = 0;
		double target = height * width * cutOff;
		while (intensitySum < target && index < histogram.length - 1) {
			intensitySum += histogram[index];
			index++;
		}
		int lowCut = index;
		//System.out.println("lowCut: " + lowCut);
		
		intensitySum = 0;
		index = histogram.length;
		while (intensitySum < target && index > 0) {
			intensitySum += histogram[histogram.length - index];
			index--;
		}
		int highCut = index;
		//System.out.println("highCut: " + highCut);
		
		Color[] grayLevels = new Color[256];
		for (int i = 0; i < 256; i++) {
			grayLevels[i] = new Color(i, i, i);
		}
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				int k;
				if (intensities[i][j] <= lowCut) {
					k = 0;
				} else if (intensities[i][j] >= highCut) {
					k = 255;
				} else {
					k = 255 * (intensities[i][j] - lowCut) / (highCut - lowCut);
				}
				
				outPixels[i][j] = grayLevels[k];
			}
		}
		return outPixels;
	}
}
