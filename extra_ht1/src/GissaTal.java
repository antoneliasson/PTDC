public class GissaTal {
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		java.util.Random rand = new java.util.Random();
		int talet = rand.nextInt(99) + 1, // 1-100
				raknare = 0,
				gissatTal;
		
		System.out.println("Jag tänker på ett tal mellan 1 och 100 - gissa vilket: ");
		do {
			gissatTal = scan.nextInt();
			if (gissatTal == talet) {
				System.out.println("Rätt på " + raknare + " försök!");
			} else if (gissatTal < talet) {
				System.out.println("För litet, försök igen: ");
			} else {
				System.out.println("För stort, försök igen: ");
			}
			raknare++;
		} while (gissatTal != talet && scan.hasNextInt());
	}
}
