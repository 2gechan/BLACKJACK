package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackExe {

	public static void main(String[] args) {
		// 게임 실행

		// Card card = new Card();

		// main에서 생성한 객체를 service 클래스에서 사용하기 위해 생성자에 매개변수 넣어주기
		Service service = new Service();

		// 카드들을 보관하기 위한 List 생성
		List<Card> cardList = new ArrayList<>();
		// 카드객체들을 사용하여 List에 저장
		Deck deck = new Deck();
		cardList = deck.makeCard();

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("--------------게임 시작--------------");
			service.giveCard(cardList); // 첫 두장 받기

			// 플레이어가 원하면 한장을 받는 method
			while (true) {

				// 플레이어는 1을 입력하면 카드를 한장 더 뽑고, 2를 입력할 경우 멈춘다

				System.out.println("draw : 1 | stop : 2");
				String pDraw = "";
				while(true) {
					pDraw = scan.nextLine();
					if (!(pDraw.equals("1") || pDraw.equals("2"))) {
						System.out.println("1 또는 2만 입력하세요.");
					}else {
						break;
					}
				}
				 if (pDraw.equals("1")) { // 더 받을지
					if (cardList.size() > 0) {
						service.phitCard(cardList);
						service.dCardList();
						service.pCardList();
					} else {
						System.out.println("남은 카드가 없어, 더이상 카드를 뽑을 수 없습니다.");
						break;
					}
				} else if (pDraw.equals("2")) { // 멈출지
					while (true) { // 플레이어가 그만 받더라도 딜러가 17미만이면 드로우
						if (service.dSum < 17) {
							if (cardList.size() > 1) {
								service.dealerCardcondition(cardList);
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}
							} else {
								System.out.println("남은 카드가 없어, 더이상 카드를 뽑을 수 없습니다.");
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
			service.whoWin();

			System.out.println("-------------------------------");
			System.out.println("종료 : Q | 계속 : 아무 key 입력");
			if (scan.nextLine().equals("Q")) {
				break;
			}

			// 카드가 4장이상 남아야지 게임진행이 가능
			if (cardList.size() < 4) {
				System.out.println("덱에 남은 카드 부족");
				System.out.println("------ 종료 ------");
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
