import se.lth.cs.ptdc.fractal.MandelbrotGUI;


public class Mandelbrot {
	public static void main(String[] args){
		MandelbrotGUI gui = new MandelbrotGUI();
		//CircleGenerator generator = new CircleGenerator();
		Generator generator = new Generator();
		int lastcommand = 0;
		boolean hasImage = false;
		do {
			lastcommand = gui.getCommand();
			switch(lastcommand){
			case MandelbrotGUI.RESET:
				gui.resetPlane();
				gui.clearPlane();
				hasImage =false;
				break;
			case MandelbrotGUI.RENDER:
				generator.render(gui);
				hasImage = true;
				break;
			case MandelbrotGUI.ZOOM:
				if(hasImage){
					generator.render(gui);
				}
				break;
			}
		}while(lastcommand != MandelbrotGUI.QUIT);
		System.exit(0);
	}
}
