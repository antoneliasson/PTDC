import se.lth.cs.ptdc.window.SimpleWindow;

public class AdvancedShapeList {
	private java.util.ArrayList<AdvancedShape> shapes;
	
	/**
	 * Skapar en tom lista.
	 */
	public AdvancedShapeList() {
		shapes = new java.util.ArrayList<AdvancedShape>();
	}
	
	/**
	 * Lägger in en figur i listan.
	 * 
	 * @param s
	 *            figuren som ska läggas in i listan
	 */
	public void insert(AdvancedShape s) {
		shapes.add(s);
	}
	
	/**
	 * Ritar upp figurerna i listan.
	 * 
	 * @param w
	 *            fönstret där figurerna ritas
	 */
	public void draw(SimpleWindow w) {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(w);
		}
	}
	
	public AdvancedShape figureAt(int xc, int yc) {
		boolean found = false;
		int i = 0;
		System.out.println("size=" + shapes.size());
		while (!found && i < shapes.size()) {
			System.out.println("loop!");
			if (shapes.get(i).contains(xc, yc)) {
				found = true;
			} else {
				i++;
			}
		}
		return found ? shapes.get(i) : null;
	}
}
