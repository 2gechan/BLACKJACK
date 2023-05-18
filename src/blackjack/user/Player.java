package blackjack.user;

public class Player {

	private int winCount = 0;

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount() {
		this.winCount += 1;
	}

}
