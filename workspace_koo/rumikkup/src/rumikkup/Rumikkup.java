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
	private int[] tempSlot = new int[180];									   // userCardList는 플레이수에 맞춰 있어야 하기에 userDTO에 포함
	
	private String[] userId = new String[4]; // 받아올값

	public Rumikkup() {


		// 게임 시작
//		startGame();
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
	
	
	
	public int skip() {
		int pickedIndex = newCard();
		whosTurn++;
		return pickedIndex;
		
	}
	
	
	
	public void save(UserDTO userDTO) {
		userList.set(userDTO.getTurn(),userDTO);
		//gameSlot은 이미 바뀌어 있음.
		
		
	}
	
	
	public void goBack() {
		gameSlot=tempSlot;
		//userDTO는 아직 바꾸지 않았음
	}
	
	
	
	public ArrayList<CardDTO> sort(ArrayList<CardDTO> userSlotList) {
//		Collections.sort(userList.get(whosTurn).getUserSlotList()); //전체 번호 순 정렬
		Collections.sort(userSlotList); 
//		return userList.get(whosTurn).getUserSlotList();
		return userSlotList;
	}
	
	
	
	
	
	public void nextTurn() {
		whosTurn++;
	}
	
	
	public void setGameSlot(int[] gameSlot) {
		tempSlot = this.gameSlot;
		this.gameSlot = gameSlot;
		//얘는 두개의 파라미터를 받기 위해 선언한 메소드, Confirm하고 세트이며, Confirm보다 먼저 호출되어야 한다.
	}
	
	public int[] getGameSlot() {
		return this.gameSlot;
	}
	
	public UserDTO rollBack(UserDTO userDTO) {
		userDTO = userList.get(userDTO.getTurn());
		return userDTO;
	}
	
	
	
	
	

	
	public boolean confirm(UserDTO userDTO) {

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
						goBack();
						return false;
					}
				}else if(gameSlot[i+1]==-1) {
					if(cardGroup>=2) {
						cardGroup=0;
					}else {
						goBack();
						return false;
					}//if
				}//if
			}//for j
		}//for i
		
		// 첫 턴 여부 검사
//		if(userList.get(whosTurn).getFirstTurn()==0) {
		if(userDTO.getFirstTurn()==0) {

			int btnNum[] = new int[20];
			
			int total =0;
//			내가 갖고 있는 gameSlotCard index랑 파라미터 gameSlotCard index랑 비교해서
//			다른 카드만 골라내서 합을 구할 순 없나? UI쪽에서 button number를 int로 넘겨주기 어려움.
			for (int i=0; i<count; i++) {
//				total = total+userList.get(whosTurn).getUserSlotList().get(btn).getNum();
				total = total+userDTO.getUserSlotList().get(btnNum).getNum();
			}
			if(total>=30) {

			}else {
				//이 메소드 탈출하고 false 리턴
			}
			
			
		}//if(for firstTurn)
		whosTurn++;
		userDTO.setFirstTurn(1);
		save(userDTO);
		return true;
		
	}//play


	
	
	
	public ArrayList<UserDTO> startGame() {

		int jokerNum = 15;
		int initialIndex = 0;
		
			for (int i = 1; i < 14; i++) {
				cardList.add(new CardDTO(i, Color.RED, initialIndex));
				initialIndex++;
				cardList.add(new CardDTO(i, Color.RED, initialIndex));
				initialIndex++;
			} // for i
		
		
			for (int i = 1; i < 14; i++) {
				cardList.add(new CardDTO(i, Color.BLUE, initialIndex));
				initialIndex++;
				cardList.add(new CardDTO(i, Color.BLUE, initialIndex));
				initialIndex++;
			} // for i
	
		
			for (int i = 1; i < 14; i++) {
				cardList.add(new CardDTO(i, Color.YELLOW, initialIndex));
				initialIndex++;
				cardList.add(new CardDTO(i, Color.YELLOW, initialIndex));
				initialIndex++;
			} // for i
		
		
			for (int i = 1; i < 14; i++) {
				cardList.add(new CardDTO(i, Color.BLACK, initialIndex));
				initialIndex++;
				cardList.add(new CardDTO(i, Color.BLACK, initialIndex));
				initialIndex++;
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
		
		return userList;
		
	}// startGame

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
