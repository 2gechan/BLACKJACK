package blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cardList = new ArrayList<>();
	
	public List<Card> makeCard() {
		String[] pattern = { "◇", "♡", "♠", "♣" };
		String[] number = { "A", "2", "3", "4", "5", "6", 
				"7", "8", "9", "10", "J", "Q", "K" };
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < number.length; j++) {
				Card card = new Card();
				card.setPattern(pattern[i]);
				card.setNumber(number[j]);
				cardList.add(card);
			}

		}
		shuffleList();
		return cardList;
	}
	
	public void shuffleList() {
		for(int i = 0; i < 10; i++) {
			Collections.shuffle(cardList);
		}
	}

}
