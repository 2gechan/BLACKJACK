package blackjack.service;

import java.util.List;

import blackjack.card.Card;
import blackjack.user.Dealer;
import blackjack.user.Player;
import blackjack.user.User;
import blackjack.utils.AnsiConsol;

public class Print {
	
	public void emptyCard(List<Card> cardList) {
		System.out.println(AnsiConsol.RED("남은 카드 개수 : ") + cardList.size());
		System.out.println(AnsiConsol.RED("남은 카드가 없어, 더이상 카드를 뽑을 수 없습니다."));
	}

	public void printCard(Dealer dealer, Player player) {

		System.out.print("---- ".repeat(dealer.dealerCard.size()));
		System.out.println();
		for (Card card : dealer.dealerCard) {
			System.out.print("|" + card.getPattern() + card.getNumber() + "| ");
		}
		System.out.println();
		System.out.print("---- ".repeat(dealer.dealerCard.size()));
		
		
		System.out.print("---- ".repeat(player.playerCard.size()));
		System.out.println();
		for (Card card : player.playerCard) {
			System.out.print("|" + card.getPattern() + card.getNumber() + "| ");
		}
		System.out.println();
		System.out.print("---- ".repeat(player.playerCard.size()));
	}

	public void scorePrint(Dealer dealer, Player player) {
		System.out.println(AnsiConsol.BLUE("-".repeat(30)));
		dealer.dCardOpen();
		player.pCardOpen();
		System.out.println(AnsiConsol.CYAN("딜러 점수 : ") + dealer.score);
		System.out.println(AnsiConsol.PURPLE("플레이어 점수 : ") + player.score);

	}

}
