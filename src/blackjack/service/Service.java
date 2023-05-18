package blackjack.service;

import java.util.ArrayList;
import java.util.List;

import blackjack.card.Card;
import blackjack.user.Dealer;
import blackjack.user.Player;
import blackjack.utils.AnsiConsol;

public class Service {

	public Dealer dealer = new Dealer();
	public Player player = new Player();

	// 플레이어와 딜러가 가지고 있는 카드 리스트
	List<Card> playerCard = new ArrayList<>();
	List<Card> dealerCard = new ArrayList<>();

	// 첫 두장 카드 분배
	public void giveCard(List<Card> cardList) {

		dhitCard(cardList);
		dhitCard(cardList);

		phitCard(cardList);
		phitCard(cardList);

		dCardList();
		pCardList();
		System.out.println();
		// 남은 카드 리스트 반환

	}

	public void dhitCard(List<Card> cardList) {
		int rnd = (int) (Math.random() * cardList.size());
		dCardSave(cardList.get(rnd));
		dPlus(cardList.get(rnd));
		cardList.remove(rnd);

	}

	public void phitCard(List<Card> cardList) {
		int rnd = (int) (Math.random() * cardList.size());
		pCardSave(cardList.get(rnd));
		pPlus(cardList.get(rnd));
		cardList.remove(rnd);
	}

	// 플레이어 카드 보관
	public void pCardSave(Card card) {
		playerCard.add(card);
	}

	// 딜러 카드 보관
	public void dCardSave(Card card) {
		dealerCard.add(card);
	}

	public int pSum = 0;
	public int dSum = 0;

	// 딜러 카드 합
	public void dPlus(Card card) {
		if (card.getNumber().equals("A")) {
			dSum += 1;
		} else if (card.getNumber().equals("J") || card.getNumber().equals("Q") || card.getNumber().equals("K")) {
			dSum += 10;
		} else {
			dSum += Integer.valueOf(card.getNumber());
		}
	}

	// 플레이어 카드 합
	public void pPlus(Card card) {
		if (card.getNumber().equals("A")) {
			pSum += 1;
		} else if (card.getNumber().equals("J") || card.getNumber().equals("Q") || card.getNumber().equals("K")) {
			pSum += 10;
		} else {
			pSum += Integer.valueOf(card.getNumber());
		}
	}

	// 딜러 카드 17 미만인 경우 실행
	public void dealerCardcondition(List<Card> cardList) {

		System.out.println(AnsiConsol.BLUE("-".repeat(30)));
		System.out.println(AnsiConsol.CYAN("딜러의 카드 합이 17미만으로 카드 추가"));
		dhitCard(cardList);
		dCardOpen();
		System.out.println(AnsiConsol.BLUE("-".repeat(30)));

	}

	// 각각 카드의 점수 합을 구한 후 승패 결정
	public void whoWin() {

		if (dSum > 21) {
			System.out.println(AnsiConsol.BLUE("-".repeat(30)));
			dCardOpen();
			pCardList();
			System.out.println(AnsiConsol.CYAN("딜러 점수 : ") + dSum);
			System.out.println(AnsiConsol.YELLOW("딜러 21 초과, 플레이어 승"));
			player.setWinCount();
		} else if (pSum > 21) {
			System.out.println(AnsiConsol.BLUE("-".repeat(30)));
			dCardOpen();
			pCardList();
			System.out.println(AnsiConsol.PURPLE("플레이어 점수 : ") + pSum);
			System.out.println(AnsiConsol.CYAN("플레이어 21 초과, 딜러 승"));
			dealer.setWinCount();
		} else if (dSum > pSum) {
			System.out.println(AnsiConsol.BLUE("-".repeat(30)));
			dCardOpen();
			pCardList();
			System.out.println(AnsiConsol.CYAN("딜러 점수 : ") + dSum);
			System.out.println(AnsiConsol.PURPLE("플레이어 점수 : ") + pSum);
			System.out.println(AnsiConsol.CYAN("딜러 승"));
			dealer.setWinCount();
		} else if (dSum < pSum) {
			System.out.println(AnsiConsol.BLUE("-".repeat(30)));
			dCardOpen();
			pCardList();
			System.out.println(AnsiConsol.CYAN("딜러 점수 : ") + dSum);
			System.out.println(AnsiConsol.PURPLE("플레이어 점수 : ") + pSum);
			System.out.println(AnsiConsol.PURPLE("플레이어 승"));
			player.setWinCount();
		} else {
			System.out.println(AnsiConsol.BLACK("무승부"));
			dCardOpen();
			pCardList();
		}
		// 승패 결정 후 갖고 있던 카드 점수 합 초기화
		dSum = 0;
		pSum = 0;
	}

	public void dCardOpen() {
		System.out.println(AnsiConsol.GREEN("딜러 카드 리스트"));
		for (Card card : dealerCard) {
			System.out.print(card.getPattern() + "-");
			System.out.print(card.getNumber() + "\t");
		}
		System.out.println();
	}

	public void dCardList() {
		System.out.println(AnsiConsol.GREEN("딜러 카드 리스트"));
		System.out.print("?\t");
		for (int i = 1; i < dealerCard.size(); i++) {
			System.out.print(dealerCard.get(i).getPattern() + "-");
			System.out.print(dealerCard.get(i).getNumber() + "\t");
		}
		System.out.println();
	}

	public void pCardList() {
		System.out.println(AnsiConsol.YELLOW("플레이어 카드 리스트"));
		for (Card card : playerCard) {
			System.out.print(card.getPattern() + "-");
			System.out.print(card.getNumber() + "\t");
		}
		System.out.println();
	}

	// 손에 쥐고 있는 패 버리기
	public void resetList() {
		playerCard = new ArrayList<>();
		dealerCard = new ArrayList<>();
	}

	public void clearScreen() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}

}