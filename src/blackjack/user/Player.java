package blackjack.user;

import java.util.List;

import blackjack.card.Card;

public class Player implements User {

	private int winCount = 0;
	private int score = 0;
	private List<Card> playerCard;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


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

	public void WinCount() {
		this.winCount += 1;
	}
}
