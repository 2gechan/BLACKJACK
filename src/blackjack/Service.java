package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Service {

	// main에서 사용하는 객체 사용하기
	Dealer dealer = new Dealer();
	Player player = new Player();

	// 플레이어와 딜러가 가지고 있는 카드 리스트
	List<Card> playerCard = new ArrayList<>();
	List<Card> dealerCard = new ArrayList<>();

	// 첫 두장 카드 분배
	public List<Card> giveCard(List<Card> card) {

		int rnd1 = (int) (Math.random() * card.size());
		dealer.setCard(card.get(rnd1));
		dCardSave(card.get(rnd1));
		dPlus(card.get(rnd1));
		// 사용한 카드 삭제
		card.remove(rnd1);

		int rnd2 = (int) (Math.random() * card.size());
		dealer.setCard(card.get(rnd2));
		dCardSave(card.get(rnd2));
		dPlus(card.get(rnd2));
		// 사용한 카드 삭제
		card.remove(rnd2);

		int rnd3 = (int) (Math.random() * card.size());
		player.setCard(card.get(rnd3));
		pCardSave(card.get(rnd3));
		pPlus(card.get(rnd3));
		// 사용한 카드 삭제
		card.remove(rnd3);

		int rnd4 = (int) (Math.random() * card.size());
		player.setCard(card.get(rnd4));
		pCardSave(card.get(rnd4));
		pPlus(card.get(rnd4));
		// 사용한 카드 삭제
		card.remove(rnd4);

		dCardList();
		pCardList();
		System.out.println();
		// 남은 카드 리스트 반환
		return card;
	}

	public void hitCard(List<Card> card) {
		int rnd = (int) (Math.random() * card.size());
		player.setCard(card.get(rnd));
		pCardSave(card.get(rnd));
		pPlus(card.get(rnd));
		dCardList();
		pCardList();
		// 사용한 카드 삭제
		card.remove(rnd);

	}

	// 플레이어 카드 보관
	public void pCardSave(Card card) {
		playerCard.add(card);
	}

	// 딜러 카드 보관
	public void dCardSave(Card card) {
		dealerCard.add(card);
	}

	int pSum = 0;
	int dSum = 0;

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
	public void dealerCardcondition(List<Card> card) {

		System.out.println("딜러의 카드 합이 17미만으로 카드 추가");
		System.out.println("-".repeat(30));
		int rnd = (int) (Math.random() * card.size());
		// dealer.setCard(card.get(rnd));
		dCardSave(card.get(rnd)); // 딜러 카드 리스트 추가
		dPlus(card.get(rnd));
		card.remove(rnd);// 뽑힌 카드 덱에서 삭제

		dCardList();
		pCardList();
		System.out.println();

	}

	// 각각 카드의 점수 합을 구한 후 승패 결정
	public void whoWin() {

		if (dSum > 21) {
			System.out.println("딜러 21 초과");
		} else if (pSum > 21) {
			System.out.println("플레이어 21 초과");
		} else if (dSum > pSum) {
			System.out.println("딜러 점수 : " + dSum);
			System.out.println("플레이어 점수 : " + pSum);
			System.out.println("딜러 승");
		} else if (dSum < pSum) {
			System.out.println("딜러 점수 : " + dSum);
			System.out.println("플레이어 점수 : " + pSum);
			System.out.println("플레이어 승");
		} else {
			System.out.println("무승부");
		}
		// 승패 결정 후 갖고 있던 카드 점수 합 초기화
		dSum = 0;
		pSum = 0;
	}

	public void dCardList() {
		System.out.println("딜러 카드 리스트");
		for (Card card : dealerCard) {
			System.out.print(card.getPattern() + "-");
			System.out.print(card.getNumber() + "\t");
		}
		System.out.println();
	}

	public void pCardList() {
		System.out.println("플레이어 카드 리스트");
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
		for(int i=0; i<15; i++) {
			System.out.println();
		}
	}

}
