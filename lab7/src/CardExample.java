import se.lth.cs.ptdc.cardGames.Card;
//import se.lth.cs.ptdc.cardGames.CardDeck;

public class CardExample {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		while (deck.moreCards()) {
			Card c = deck.getCard();
			String suitString = "";
			switch (c.getSuit()) {
				case Card.SPADES: suitString = "Spader"; break;
				case Card.HEARTS: suitString = "Hjärter"; break;
				case Card.DIAMONDS: suitString = "Ruter"; break;
				case Card.CLUBS: suitString = "Klöver"; break;
			}
			System.out.println(suitString + " " + c.getRank());
		}
	}
}
