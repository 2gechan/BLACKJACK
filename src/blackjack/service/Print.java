package blackjack.service;

import java.util.List;

import blackjack.card.Card;
import blackjack.utils.AnsiConsol;

public class Print {
	
	public void emptyCard(List<Card> cardList) {
		System.out.println(AnsiConsol.RED("남은 카드 개수 : ") + cardList.size());
		System.out.println(AnsiConsol.RED("남은 카드가 없어, 더이상 카드를 뽑을 수 없습니다."));
	}

}
