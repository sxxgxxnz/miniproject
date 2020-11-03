package rumikkup;

import java.util.ArrayList;
import java.util.Collections;


public class Rumikkup {

	private ArrayList<CardDTO> cardList = new ArrayList<CardDTO>();
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	private int userNum; // �޾ƿð�
	private int[] usedCardIndex = new int[106];
	private int whosTurn = 0;
	private int cardGroup = 0;
	private int[] gameSlot = new int[180]; // ArrayListó�� ��ĭ�� ����� �ȵǼ� ArrayList ��� �Ұ�
	private int[] tempSlot = new int[180];									   // userCardList�� �÷��̼��� ���� �־�� �ϱ⿡ userDTO�� ����
	
	private String[] userId = new String[4]; // �޾ƿð�

	public Rumikkup() {


		// ���� ����
//		startGame();
//
//		// ���ο� ī�� �̱�
//		newCard();
//
//		// Ȯ�ι�ư (��Ģ �˻�)
//		confirm();
//
//		// �� �ѱ��
//		nextTurn();
//		
//		// �����ϱ�
//		sort();
//		
//		// ������ ����
//		save();
		
		// 
		
	}// ������
	
	
	
	public int skip() {
		int pickedIndex = newCard();
		whosTurn++;
		return pickedIndex;
		
	}
	
	
	
	public void save(UserDTO userDTO) {
		userList.set(userDTO.getTurn(),userDTO);
		//gameSlot�� �̹� �ٲ�� ����.
		
		
	}
	
	
	public void goBack() {
		gameSlot=tempSlot;
		//userDTO�� ���� �ٲ��� �ʾ���
	}
	
	
	
	public ArrayList<CardDTO> sort(ArrayList<CardDTO> userSlotList) {
//		Collections.sort(userList.get(whosTurn).getUserSlotList()); //��ü ��ȣ �� ����
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
		//��� �ΰ��� �Ķ���͸� �ޱ� ���� ������ �޼ҵ�, Confirm�ϰ� ��Ʈ�̸�, Confirm���� ���� ȣ��Ǿ�� �Ѵ�.
	}
	
	public int[] getGameSlot() {
		return this.gameSlot;
	}
	
	public UserDTO rollBack(UserDTO userDTO) {
		userDTO = userList.get(userDTO.getTurn());
		return userDTO;
	}
	
	
	
	
	

	
	public boolean confirm(UserDTO userDTO) {

		//��,�� ��
		for(int i=0; i<8; i++) {
			for(int j=0; j<18; i++) {
				//���� ��� ī�� ����
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
		
		// ù �� ���� �˻�
//		if(userList.get(whosTurn).getFirstTurn()==0) {
		if(userDTO.getFirstTurn()==0) {

			int btnNum[] = new int[20];
			
			int total =0;
//			���� ���� �ִ� gameSlotCard index�� �Ķ���� gameSlotCard index�� ���ؼ�
//			�ٸ� ī�常 ��󳻼� ���� ���� �� ����? UI�ʿ��� button number�� int�� �Ѱ��ֱ� �����.
			for (int i=0; i<count; i++) {
//				total = total+userList.get(whosTurn).getUserSlotList().get(btn).getNum();
				total = total+userDTO.getUserSlotList().get(btnNum).getNum();
			}
			if(total>=30) {

			}else {
				//�� �޼ҵ� Ż���ϰ� false ����
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
		
		// ī�� ���� Ȯ�ο� �ڵ�
		for (int i = 0; i < cardList.size(); i++) {
			System.out.print(cardList.get(i).getColor() + " ");
			System.out.print(cardList.get(i).getNum() + " ");
			System.out.println(cardList.get(i).getIndex());
		}//for
		System.out.println("ī��� �� " + cardList.size() + "��");

		
		// ���ӽ��� ī�� ���� ǥ��
		for (int i = 0; i < 180; i++) {
			gameSlot[i] = -1;
		}//for

		// �̹� �Ҵ�� ī�� ǥ��
		for (int i = 0; i < 106; i++) {
			usedCardIndex[i] = 0;
		}//for
		

		// ���� ���� �� ī�� �й�
		for (int i = 0; i < userNum; i++) {
			userList.add(new UserDTO(userId[i],i));
			// 13���� ������ ī�� ����, ���� ī�� ��� �� ���Կ� �߰�
			for (int j = 0; j < 13; j++) {
				int newCardIndex = newCard();
				userList.get(i).getUserSlotList().add(cardList.get(newCardIndex));
			} // for j
		} // for i
		
		return userList;
		
	}// startGame

	public int newCard() {
		int pickedIndex = ((int) (Math.random() * 106) + 1); // 1~106������ ����
		while (usedCardIndex[pickedIndex] == 1) { // �̹� �й�� ī���� �ٽ� ������ ����
			pickedIndex = ((int) (Math.random() * 106) + 1);
		} // while
			// ������ ���� �ε�����ȣ�� ī��DTO�� ��üī���̿��� ���� ����DTO�� ����ī���̿� �߰��ϴ� ����

		usedCardIndex[pickedIndex] = 1; // �й�� ī�带 ǥ���ص�
		return pickedIndex;
	}// newCard

	



	
}// public
