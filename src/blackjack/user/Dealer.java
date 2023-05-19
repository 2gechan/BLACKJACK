package blackjack.user;

import java.util.List;

import blackjack.card.Card;

public class Dealer {
	
	private int winCount = 0;
	private List<Card> dealerCard;
	

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

	public void setWinCount() {
		this.winCount += 1;
	}
}
