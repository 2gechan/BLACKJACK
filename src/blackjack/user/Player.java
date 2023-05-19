package blackjack.user;

import java.util.List;

import blackjack.card.Card;

public class Player {

	private int winCount = 0;
	private List<Card> playerCard;

	public List<Card> getPlayerCard() {
		return playerCard;
	}

	public void setPlayerCard(List<Card> playerCard) {
		this.playerCard = playerCard;
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
