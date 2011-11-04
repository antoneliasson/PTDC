import se.lth.cs.ptdc.cardGames.Card;
//import se.lth.cs.ptdc.cardGames.CardDeck;

public class Solitaire123 {
	public static void main(String[] args) {
		final int GAMES = 1000000; // antal patienser
		int wins = 0;
		
		// det kan inte vara kul att vara dator...
		for (int i = 0; i < GAMES; i++) {
			if (!play()) {
				wins++;
			}
		}
		System.out.println("Patiensen gick ut " + wins + " gånger av " + GAMES +
				"\nSannolikhet: " + (double) wins / GAMES);
	}
	
	public static boolean play() {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		int count = 0;
		boolean lost = false;
		
		// fortsätter patiensen så länge det finns kort kvar och man inte har förlorat
		while (deck.moreCards() && !lost) {
			Card c = deck.getCard();
			
			if (c.getRank() == count + 1) {
				lost = true;
			}
			count = (count + 1) % 3;
		}
		return lost; // true om spelet är förlorat, false om patiensen gick ut
	}
}
