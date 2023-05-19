package blackjack.service;

import java.util.List;

import blackjack.card.Card;
import blackjack.user.Dealer;
import blackjack.user.Player;
import blackjack.user.User;
import blackjack.utils.AnsiConsol;

public class Print {
	Player p = new Player();
	Dealer d = new Dealer();
	
	public void emptyCard(List<Card> cardList) {
		System.out.println(AnsiConsol.RED("남은 카드 개수 : ") + cardList.size());
		System.out.println(AnsiConsol.RED("남은 카드가 없어, 더이상 카드를 뽑을 수 없습니다."));
	}
	
	public void test() {
		
		for(Card card : p.getPlayerCard()) {
			System.out.println("----");
			System.out.println("|"+card.getPattern()+card.getNumber()+"|");
			System.out.println("----");
		}
	}

}
