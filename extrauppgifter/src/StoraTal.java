import java.math.BigInteger;

public class StoraTal {
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Ange fakultet: ");
		int fakultet = scan.nextInt();
		BigInteger biggaint = new BigInteger(String.valueOf(1));
		
		for (int i = fakultet; i > 1; i--) {
			biggaint = biggaint.multiply(BigInteger.valueOf(i));
		}
		System.out.println("Resultat: " + biggaint.toString());
	}
}
