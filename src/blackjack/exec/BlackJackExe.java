package blackjack.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import blackjack.card.Card;
import blackjack.card.Deck;
import blackjack.service.Print;
import blackjack.service.Service;
import blackjack.utils.AnsiConsol;

public class BlackJackExe {

	public void gameStart() {
		// 게임 실행
		Service service = new Service();
		Print print = new Print();

		List<Card> cardList = new ArrayList<>();
		Deck deck = new Deck();
		cardList = deck.makeCard();
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(AnsiConsol.CYAN("--------------게임 시작--------------"));

			service.giveCard(cardList); // 첫 두장 받기

			while (true) {

				// 플레이어는 1을 입력하면 카드를 한장 더 뽑고, 2를 입력할 경우 멈춘다
				System.out.print(AnsiConsol.GREEN("draw : 1 | stop : 2 >> "));
				String pDraw = "";
				while (true) {
					pDraw = scan.nextLine();
					if (!(pDraw.equals("1") || pDraw.equals("2"))) {
						System.out.println(AnsiConsol.GREEN("1 또는 2만 입력하세요."));
					} else {
						break;
					}
				}
				if (pDraw.equals("1")) { // 더 받을지

					if (cardList.size() > 0) {
						service.phitCard(cardList);
						System.out.println(AnsiConsol.BLUE("-".repeat(30)));
						service.dCardList();
						service.pCardList();
					} else {
						print.emptyCard(cardList);
						break;
					}
				} else if (pDraw.equals("2")) { // 멈출지
					while (true) { 
						if (service.dSum < 17) {
							if (cardList.size() > 1) {
								service.dealerCardcondition(cardList);
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}
							} else {
								print.emptyCard(cardList);
								break;
							}
						} else {
							break;
						}
					}
					break;
				}
				if (service.pSum > 21) {
					break;
				}

			} // end while
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			service.whoWin();

			System.out.println(AnsiConsol.BLUE("-".repeat(30)));
			System.out.println(AnsiConsol.GREEN("종료 : QUIT | 계속 : 아무 key 입력"));
			if (scan.nextLine().equals("QUIT")) {
				break;
			}

			// 카드가 4장이상 남아야지 게임진행이 가능
			if (cardList.size() < 4) {
				print.emptyCard(cardList);
				System.out.println("종료합니다.");
				System.out.println(AnsiConsol.BLUE("-".repeat(30)));
				break;
			}
			// 승패 결정 후 플레이어와 딜러의 카드 리스트 리셋
			service.resetList();
			service.clearScreen();

		}

		System.out.println("딜러 승리 횟수 : " + service.dealer.getWinCount());
		System.out.println("플레이어 승리 횟수 : " + service.player.getWinCount());

		scan.close();

	}
}
