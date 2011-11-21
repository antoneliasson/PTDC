import se.lth.cs.ptdc.fractal.MandelbrotGUI;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private ArrayList<Color> colors;

	public Generator(){
		colors = new ArrayList<Color>();
		Random r = new Random();		
		for(int i =0; i<200; i++){
			colors.add(new Color((int)(r.nextDouble()*((double)Integer.MAX_VALUE - (double)Integer.MIN_VALUE) + Integer.MIN_VALUE)));
		}
	}
	
	/**
	 * Ritar en bild i fönstret i användargränssnittet gui
	 * @param gui
	 */
	public void render(MandelbrotGUI gui){
		gui.disableInput();
		int pixelSize;
		switch(gui.getResolution()){
		case MandelbrotGUI.RESOLUTION_VERY_HIGH: 
			pixelSize = 1;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			pixelSize = 3;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM: 
			pixelSize = 5;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			pixelSize = 7;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_LOW: 
			pixelSize = 9;
			break;
		default:pixelSize = 1;
		}
		int width = gui.getWidth(), height = gui.getHeight();
		Complex[][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(), 
				width, height);
		Color[][] picture = new Color[Math.round((float)height/pixelSize)][Math.round((float)width/pixelSize)];
		for(int y =0; y<picture.length; y++){
			for(int x = 0; x<picture[0].length; x++){
				Complex c = mesh[pixelSize/2 + y*pixelSize][pixelSize/2 + x*pixelSize];
				Complex old = new Complex(0,0);
				int i = 0;
				while(i<200 && old.getAbs2()<4){
					old.mul(old);
					old.add(c);
					i++;
				}
				if(gui.getMode() == MandelbrotGUI.MODE_BW){
					if(i<200){
						picture[y][x] = Color.WHITE;
					}else{
						picture[y][x] = Color.BLACK;
					}
				}else{
					if(i<200){
						picture[y][x] = colors.get(i);
					}
					else{
						picture[y][x] = Color.BLACK;
					}
				}
			}
		}
		gui.putData(picture, pixelSize, pixelSize);
		gui.enableInput();

	}
	
	/**
	 * Skapar en matris där varje element är ett komplext tal som
	 * har rätt koordinater
	 * @param minRe
	 * @param maxRe
	 * @param minIm
	 * @param maxIm
	 * @param width
	 * @param height
	 * @return
	 */
	public Complex[][] mesh(double minRe, double maxRe,
			double minIm, double maxIm,
			int width, int height){
		Complex[][] mesh = new Complex[height][width];
		double yStep = (maxIm - minIm) / (height-1);
		double xStep = (maxRe - minRe) / (width-1);

		for(int y =0; y<height; y++){
			for(int x = 0; x<width; x++){
				mesh[y][x] = new Complex(minRe + x * xStep, maxIm -y * yStep);
			}
		}
		return mesh;
	}
}
