package rumikkup;

import java.util.ArrayList;
import java.util.Collections;


public class Rumikkup {

	private ArrayList<CardDTO> cardList = new ArrayList<CardDTO>();
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	private int userNum; // 받아올값
	private int[] usedCardIndex = new int[106];
	private int whosTurn = 0;
	private int cardGroup = 0;
	private int[] gameSlot = new int[180]; // ArrayList처럼 빈칸을 땅기면 안되서 ArrayList 사용 불가
										   // userCardList는 플레이수에 맞춰 있어야 하기에 userDTO에 포함
	
	private String[] userId = new String[4]; // 받아올값

	public Rumikkup() {
		// 카드 생성
		makeCard();

//		// 초기 게임 셋팅
//		setGame();
//
//		// 새로운 카드 뽑기
//		newCard();
//
//		// 확인버튼 (규칙 검사)
//		confirm();
//
//		// 턴 넘기기
//		nextTurn();
//		
//		// 정렬하기
//		sort();
//		
//		// 데이터 저장
//		save();
		
		// 
		
	}// 생성자
	
	
	
	public void save() {
		int a = 0; // 카드 슬롯번호
		CardDTO b = new CardDTO(1,Color.BLUE, 1); // 해당 슬롯에 들거나 카드DTO, UI로부터 받을 입력 값들
		gameSlot[a] = b.getIndex();
		//데이터가 몇개가 들어올지 모름.
	}
	
	
	
	
	
	
	public void sort() {
		Collections.sort(userList.get(whosTurn).getUserSlotList()); //전체 번호 순 정렬
	}
	
	
	
	
	
	public void nextTurn() {
		whosTurn++;
	}
	
	
	
	
	
	public void confirm() {
		//유저슬롯에서 게임슬롯으로 카드 옮기는 상황
//		gameSlot[btn1] = userList.get(whosTurn).getUserSlotList().get(btn).getIndex(); //옮겨넣고
//		userList.get(whosTurn).getUserSlotList().remove(btn); //삭제
		
		//게임슬롯에서 게임슬롯으로 카드 옮기는 상황
//		gameSlot[btn] = gameSlot[btn1];
//		gameSlot[btn1] = 0;
		
		// 첫 턴 여부 검사
		if(userList.get(whosTurn).getFirstTurn()==0) {
			firstTurn();
		}else if(userList.get(whosTurn).getFirstTurn()==1) {
		
	
		
		//좌,우 비교
		for(int i=0; i<8; i++) {
			for(int j=0; j<18; i++) {
				//양측 모두 카드 있음
				if(gameSlot[i+1]!=-1) {
					if(cardList.get(gameSlot[j+(i*20)]).getColor()==cardList.get(gameSlot[j+(i*20)+1]).getColor()){
						if(cardList.get(gameSlot[j+(i*20)]).getNum()==(cardList.get(gameSlot[j+(i*20)+1]).getNum())+1) {
							cardGroup++;
						}//if
					}else if(cardList.get(gameSlot[j+(i*20)]).getColor()!=cardList.get(gameSlot[j+(i*20)+1]).getColor()) {
						if(cardList.get(gameSlot[j+(i*20)]).getNum()==(cardList.get(gameSlot[j+(i*20)+1]).getNum())) {
							cardGroup++;
						}//if
					}else {
						//원복//
					}
				}else if(gameSlot[i+1]==-1) {
					if(cardGroup>=3) {
						//데이터 저장//
					}else {
						//원복//
					}
				}
			}//for j
		}//for i
		}//if(for firstTurn)
		whosTurn++;
	}//play


	public void firstTurn() {
		
		int btn = 0; //버튼 통해서 들어올 인트값(슬롯번호)
		if(userList.get(whosTurn).getUserSlotList().get(btn).getNum()
		+userList.get(whosTurn).getUserSlotList().get(btn).getNum()
		+userList.get(whosTurn).getUserSlotList().get(btn).getNum()>=30) {
			//데이터 저장//
		}else {
			//원복//
		}
		
		userList.get(whosTurn).setFirstTurn(1);
		whosTurn++;
	}
	
	
	
	public void makeCard() {

		int jokerNum = 15;
		int initialIndex = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 14; j++) {
				cardList.add(new CardDTO(j, Color.RED, initialIndex));
				initialIndex++;
			} // for j
		} // for i
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 14; j++) {
				cardList.add(new CardDTO(j, Color.BLUE, initialIndex));
				initialIndex++;
			} // for j
		} // for i
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 14; j++) {
				cardList.add(new CardDTO(j, Color.YELLOW, initialIndex));
				initialIndex++;
			} // for j
		} // for i
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 14; j++) {
				cardList.add(new CardDTO(j, Color.BLACK, initialIndex));
				initialIndex++;
			} // for j
		} // for i
		cardList.add(new CardDTO(jokerNum, Color.JOKER, initialIndex));
		initialIndex++;
		cardList.add(new CardDTO(jokerNum, Color.JOKER, initialIndex));
		initialIndex++;
		
		// 카드 생성 확인용 코드
		for (int i = 0; i < cardList.size(); i++) {
			System.out.print(cardList.get(i).getColor() + " ");
			System.out.print(cardList.get(i).getNum() + " ");
			System.out.println(cardList.get(i).getIndex());
		}//for

		System.out.println("카드는 총 " + cardList.size() + "장");

	}// makeCard

	public void setGame() {
		// 게임슬롯 카드 유무 표시
		for (int i = 0; i < 180; i++) {
			gameSlot[i] = -1;
		}//for

		// 이미 할당된 카드 표시
		for (int i = 0; i < 106; i++) {
			usedCardIndex[i] = 0;
		}//for
		

		// 유저 생성 및 카드 분배
		for (int i = 0; i < userNum; i++) {
			userList.add(new UserDTO(userId[i],i));
			// 13장의 무작위 카드 생성, 유저 카드 목록 및 슬롯에 추가
			for (int j = 0; j < 13; j++) {
				int newCardIndex = newCard();
				userList.get(i).getUserSlotList().add(cardList.get(newCardIndex));
			} // for j
		} // for i
	}// setGame

	public int newCard() {
		int pickedIndex = ((int) (Math.random() * 106) + 1); // 1~106사이의 난수
		while (usedCardIndex[pickedIndex] == 1) { // 이미 분배된 카드라면 다시 난수로 받음
			pickedIndex = ((int) (Math.random() * 106) + 1);
		} // while
			// 난수로 얻은 인덱스번호의 카드DTO를 전체카드어레이에서 꺼내 유저DTO의 유저카드어레이에 추가하는 구문

		usedCardIndex[pickedIndex] = 1; // 분배된 카드를 표시해둠
		return pickedIndex;
	}// newCard

	



	
}// public
