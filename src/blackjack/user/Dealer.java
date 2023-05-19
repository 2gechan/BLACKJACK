package blackjack.user;

import java.util.ArrayList;
import java.util.List;

import blackjack.card.Card;
import blackjack.utils.AnsiConsol;

public class Dealer implements User {
	
	private int winCount = 0;
	public int score = 0;
	public List<Card> dealerCard;
	
	public Dealer() {
		dealerCard = new ArrayList<>();
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getWinCount() {
		return winCount;
	}

	public void WinCount() {
		this.winCount += 1;
	}
	
	public void dCardOpen() {
		System.out.println(AnsiConsol.GREEN("딜러 카드 리스트"));
		for (Card card : dealerCard) {
			System.out.print(card.getPattern() + "-");
			System.out.print(card.getNumber() + "\t");
		}
		System.out.println();
	}
	
}
