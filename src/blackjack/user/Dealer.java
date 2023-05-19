package blackjack.user;

import java.util.List;

import blackjack.card.Card;

public class Dealer implements User {
	
	private int winCount = 0;
	private int score = 0;
	private List<Card> dealerCard;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getDealerCard() {
		return dealerCard;
	}

	public void setDealerCard(List<Card> dealerCard) {
		this.dealerCard = dealerCard;
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
}
