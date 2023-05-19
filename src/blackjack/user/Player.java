package blackjack.user;

import java.util.ArrayList;
import java.util.List;

import blackjack.card.Card;
import blackjack.utils.AnsiConsol;

public class Player implements User {

	private int winCount = 0;
	public int score = 0;
	public List<Card> playerCard;
	
	public Player() {
		playerCard = new ArrayList<>();
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
	
	public void pCardOpen() {
		System.out.println(AnsiConsol.YELLOW("플레이어 카드 리스트"));
		for (Card card : playerCard) {
			System.out.print(card.getPattern() + "-");
			System.out.print(card.getNumber() + "\t");
		}
		System.out.println();
	}
}
