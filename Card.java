
public class Card implements Comparable<Card> {

	private final Rank rank;
	private final Suit suit;

	public Card(Rank cardRank, Suit cardSuit){
		this.rank = cardRank;
		this.suit = cardSuit;
	}

	public Rank getRank(){
		return this.rank;
	}

	public Suit getSuit(){
		return this.suit;
	}

	public int getValue() {
		switch (this.rank) {
		case Deuce:
			return 2;

		case Three:
			return 3;

		case Four:
			return 4;

		case Five:
			return 5;

		case Six:
			return 6;

		case Seven:
			return 7;

		case Eight:
			return 8;

		case Nine:
			return 9;

		case Ten:
			return 10;

		case Jack:
			return 11;

		case Queen:
			return 12;

		case King:
			return 13;

		default:
			return 14;

		}
	}
	
	public int compareTo(Card card){
		if(this.getValue() > card.getValue()){
			return 1;
		}
		
		else if(this.getValue() < card.getValue()){
			return -1;
		}
		
		else{
			return 0;
		}
	}
}
