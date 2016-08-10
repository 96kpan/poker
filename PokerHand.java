import java.util.*;

public class PokerHand implements Comparable<PokerHand>{

	private HandRank handRank;
	private Card[] cards = new Card[5];
	HashMap<Integer, Integer> rankMap;

	//constructor for PokerHand
	public PokerHand(Card card0, Card card1, Card card2, Card card3, Card card4) {
		cards[0] = card0;
		cards[1] = card1;
		cards[2] = card2;
		cards[3] = card3;
		cards[4] = card4;

		if(duplicateCards(this)){
			throw new DuplicateCardException();
		}

		handRank = calculateRank(cards);
	}

	//duplicate cards in self-deck
	private boolean duplicateCards(PokerHand deck){
		for(int i = 0; i < deck.cards.length; i++){
			for(int j = i+1; j < deck.cards.length; j++){
				if(deck.cards[i].getValue() == deck.cards[j].getValue() &&
						deck.cards[i].getSuit() == deck.cards[j].getSuit()){
					return true;
				}
			}
		}

		return false;
	}

	//get key from value
	@SuppressWarnings("rawtypes")
	public Integer getKeyFromValue( Integer freq) {
		HashMap<Integer,Integer> hm = rankMap;
		for (Integer o : hm.keySet()) {
			if (hm.get(o).equals(freq)) {
				return o;
			}
		}
		return null;
	}

	//tie breakers for each
	private int tieBreakers(PokerHand hand, PokerHand otherHand) throws DuplicateCardException{

		//duplicate card in two hands
		for(int i = 0; i < hand.cards.length; i++){
			for(int j = 0; j < otherHand.cards.length; j++){
				if(otherHand.cards[i].getValue() == hand.cards[j].getValue() &&
						otherHand.cards[i].getSuit() == hand.cards[j].getSuit()){
					throw new DuplicateCardException();
				}
			}
		}

		int handValue1, handValue2;

		HandRank calculateHandRank = calculateRank(hand.cards);
		for ( int i = 0 ; i < 5; ++i){
			System.out.println(hand.cards[i].getValue());
		}
		
		
		System.out.println(calculateHandRank);

		switch (calculateHandRank){
		
			//four of a kind
			case Four_of_a_Kind: 
				handValue1 = hand.getKeyFromValue(4);
				handValue2 = otherHand.getKeyFromValue(4);
	
				if(handValue1 > handValue2)
					return 1;
				if(handValue1 < handValue2)
					return -1;
				return 0;
			//full house
			case Full_House:
				handValue1 = hand.getKeyFromValue(3);
				handValue2 = otherHand.getKeyFromValue( 3);
				
				if(handValue1 > handValue2)
					return 1;
				if(handValue1 < handValue2)
					return -1;
				return 0;
			//three of a kind
			case Three_of_a_Kind:
				handValue1 = hand.getKeyFromValue(3);
				handValue2 = otherHand.getKeyFromValue(3);
				
				if(handValue1 > handValue2)
					return 1;
				if(handValue1 < handValue2)
					return -1;
				return 0;
			//pair
			case Pair:
				handValue1 = hand.getKeyFromValue(2);
				handValue2 = otherHand.getKeyFromValue(2);
	
				if(handValue1 > handValue2)
					return 1;
					
				if(handValue1 < handValue2)
					return -1;
				return compareHand(hand, otherHand);
			//flush
			case Flush:
				compareHand(hand, otherHand);
			//straight
			case Straight:
				compareHand(hand, otherHand);
			
			//two pair
			case Two_Pair:  
				compareHand(hand, otherHand);
			
		}
		//nothing
		return compareHand(hand, otherHand);

	}

	private int compareHand(PokerHand hand, PokerHand otherHand){
		
		Arrays.sort(hand.cards);
		Arrays.sort(otherHand.cards);
		
		for(int i = 4; i >= 0; i--){
			//System.out.println(hand.cards[i].getRank().ordinal() + " " + otherHand.cards[i].getRank().ordinal());
			if(hand.cards[i].getRank().ordinal() < otherHand.cards[i].getRank().ordinal()){
				return -1;
			}
			else if(hand.cards[i].getRank().ordinal() > otherHand.cards[i].getRank().ordinal()){
				return 1;
			}
		}
		
		return 0;
	}

	private boolean sameSuit(Card[] deck){
		if(deck[0].getSuit() == deck[1].getSuit() &&
				deck[0].getSuit() == deck[2].getSuit() &&
				deck[0].getSuit() == deck[3].getSuit() &&
				deck[0].getSuit() == deck[4].getSuit()){
			return true;
		}

		return false;
	}

	private boolean isChronological(Card[] deck){
		if((deck[0].getValue() + 1) == deck[1].getValue() &&
				(deck[0].getValue() + 2) == deck[2].getValue() &&
				(deck[0].getValue() + 3) == deck[3].getValue() &&
				(deck[0].getValue() + 4) == deck[4].getValue()){
			return true;
		}
		return false;
	}

	private HandRank calculateRank(Card[] deck){
		rankMap = new HashMap<Integer,Integer>();
		for(int i = 0; i < deck.length; i++){
			if(rankMap.containsKey(deck[i].getValue())){
				rankMap.put(deck[i].getValue(), rankMap.get(deck[i].getValue()) + 1);
			}
			else{
				rankMap.put(deck[i].getValue(), 1);
			}
		}

		if(sameSuit(deck)){
			if(isChronological(deck)){
				//straight flush
				return HandRank.Straight_Flush;
			}
			//flush
			return HandRank.Flush;
		}

		//straight
		if(isChronological(deck)){
			return HandRank.Straight;
		}

		//Four of a kind
		if(rankMap.containsValue(4)){
			return HandRank.Four_of_a_Kind;
		}

		//Three of a kind
		else if(rankMap.containsValue(3)){

			//full house
			if(rankMap.containsValue(2)){
				return HandRank.Full_House;
			}

			return HandRank.Three_of_a_Kind;
		}

		//two pairs
		else if(rankMap.containsValue(2)){
			//two pairs
			int count = 0;

			for(Integer value : rankMap.values()){

				if(value == 2){
					count++;
				}

			}
			
			//System.out.println("pairs: " + count);
			
			if(count == 2){
				return HandRank.Two_Pair;
			}

			//one pair
			else{
				return HandRank.Pair;
			}

		}

		return HandRank.Nothing;
	}

	@Override
	public int compareTo(PokerHand otherDeck) {
		
		Arrays.sort(this.cards);
		Arrays.sort(otherDeck.cards);
		
		System.out.println("this " + this.handRank);
		System.out.println("other " + otherDeck.handRank);
		
		if(calculateRank(this.cards).ordinal() > calculateRank(otherDeck.cards).ordinal()){
			return 1;
		}

		else if(calculateRank(this.cards).ordinal() < calculateRank(otherDeck.cards).ordinal()){
			
			return -1;
		}

		else {
			
			return tieBreakers(this, otherDeck);

		}

	}
}
