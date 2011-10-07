// Övning 3, uppgift 5

public class Betygsmaskinen {
	public static void main(String[] args) {
		int antal = 0, nollor = 0;
		double medel = 0;
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		while (scan.hasNextInt()) {
			int betyg = scan.nextInt();
			if (betyg == 0) {
				nollor++;
			}
			medel += betyg;
			antal++;
		}
		medel /= antal; // beräknar slutliga medelvärdet
		System.out.println("Antal betyg: " + antal + "\nUnderkända: " + nollor +
				(antal > nollor ? "\nGodkända: " + (antal - nollor) : "\nInga godkända") +
				"\nMedelvärde: " + medel);
	}
}
