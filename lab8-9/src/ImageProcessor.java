import se.lth.cs.ptdc.images.ImageFilter;
import se.lth.cs.ptdc.images.ImageGUI;

public class ImageProcessor {
	public static void main(String[] args) {
		//ImageFilter[] filters = new ImageFilter[1];
		//filters[0] = new IdentityFilter("Identity Filter");
		ImageFilter[] filters = {new IdentityFilter("Identity Filter"),
				new BlueFilter("Blue Filter"),
				new InvertFilter("Invert Filter"),
				new GrayScaleFilter("Gray Scale Filter"), // blir inte bilden lite sämre av detta filter?
				new QuickGrayScaleFilter("Quick Gray Scale Filter"),
				new ContrastFilter("Contrast Filter")};
		new ImageGUI(filters);
	}
}
