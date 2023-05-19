package blackjack.service;

import java.util.ArrayList;
import java.util.List;

import blackjack.card.Card;
import blackjack.user.Dealer;
import blackjack.user.Player;
import blackjack.utils.AnsiConsol;

public class Service {
	Print print = new Print();
	// 플레이어와 딜러가 가지고 있는 카드 리스트
	
	// 첫 두장 카드 분배
	public void giveCard(List<Card> cardList, Dealer dealer, Player player) {
		dhitCard(cardList, dealer, player);
		phitCard(cardList, dealer, player);

		dhitCard(cardList, dealer, player);
		phitCard(cardList, dealer, player);

		cardOpen(dealer, player);
		System.out.println();
		// 남은 카드 리스트 반환

	}

	public void dhitCard(List<Card> cardList, Dealer dealer, Player player) {
		dCardSave(cardList.get(0), dealer);
		dPlus(cardList.get(0), dealer);
		print.printCard(dealer, player);
		cardList.remove(0);
	}

	public void phitCard(List<Card> cardList,Dealer dealer, Player player) {
		pCardSave(cardList.get(0), player);
		pPlus(cardList.get(0), player);
		print.printCard(dealer, player);
		cardList.remove(0);
	}

	// 플레이어 카드 보관
	public void pCardSave(Card card, Player player) {
		player.playerCard.add(card);
	}

	// 딜러 카드 보관
	public void dCardSave(Card card, Dealer dealer) {
		dealer.dealerCard.add(card);
	}

	// 딜러 카드 합
	public void dPlus(Card card, Dealer dealer) {
		if (card.getNumber().equals("A")) {
			dealer.score += 1;
		} else if (card.getNumber().equals("J") || card.getNumber().equals("Q") || card.getNumber().equals("K")) {
			dealer.score += 10;
		} else {
			dealer.score += Integer.valueOf(card.getNumber());
		}
	}

	// 플레이어 카드 합
	public void pPlus(Card card, Player player) {
		if (card.getNumber().equals("A")) {
			player.score += 1;
		} else if (card.getNumber().equals("J") || card.getNumber().equals("Q") || card.getNumber().equals("K")) {
			player.score += 10;
		} else {
			player.score += Integer.valueOf(card.getNumber());
		}
	}

	// 각각 카드의 점수 합을 구한 후 승패 결정
	public void whoWin(Dealer dealer, Player player) {

		if (dealer.score > 21) {
			print.scorePrint(dealer, player);
			System.out.println(AnsiConsol.YELLOW("딜러 21 초과, 플레이어 승"));
			player.WinCount();
		} else if (player.score > 21) {
			print.scorePrint(dealer, player);
			System.out.println(AnsiConsol.PURPLE("플레이어 21 초과, 딜러 승"));
			dealer.WinCount();
		} else if (dealer.score > player.score) {
			print.scorePrint(dealer, player);
			System.out.println(AnsiConsol.PURPLE("딜러 승"));
			dealer.WinCount();
		} else if (dealer.score < player.score) {
			print.scorePrint(dealer, player);
			System.out.println(AnsiConsol.PURPLE("플레이어 승"));
			player.WinCount();
		} else {
			System.out.println(AnsiConsol.BLACK("무승부"));
			dealer.dCardOpen();
			cardOpen(dealer, player);
		}
		// 승패 결정 후 갖고 있던 카드 점수 합 초기화
		dealer.score = 0;
		player.score = 0;
	}

	public void cardOpen (Dealer dealer, Player player) {
		dealer.dCardOpen();
		player.pCardOpen();
	}

	// 손에 쥐고 있는 패 버리기
	public void resetList(Dealer dealer, Player player) {
		player.playerCard = new ArrayList<>();
		dealer.dealerCard = new ArrayList<>();
	}

}