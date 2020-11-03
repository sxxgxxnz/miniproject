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
										   // userCardList�� �÷��̼��� ���� �־�� �ϱ⿡ userDTO�� ����
	
	private String[] userId = new String[4]; // �޾ƿð�

	public Rumikkup() {
		// ī�� ����
		makeCard();

//		// �ʱ� ���� ����
//		setGame();
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
	
	
	
	public void save() {
		int a = 0; // ī�� ���Թ�ȣ
		CardDTO b = new CardDTO(1,Color.BLUE, 1); // �ش� ���Կ� ��ų� ī��DTO, UI�κ��� ���� �Է� ����
		gameSlot[a] = b.getIndex();
		//�����Ͱ� ��� ������ ��.
	}
	
	
	
	
	
	
	public void sort() {
		Collections.sort(userList.get(whosTurn).getUserSlotList()); //��ü ��ȣ �� ����
	}
	
	
	
	
	
	public void nextTurn() {
		whosTurn++;
	}
	
	
	
	
	
	public void confirm() {
		//�������Կ��� ���ӽ������� ī�� �ű�� ��Ȳ
//		gameSlot[btn1] = userList.get(whosTurn).getUserSlotList().get(btn).getIndex(); //�Űְܳ�
//		userList.get(whosTurn).getUserSlotList().remove(btn); //����
		
		//���ӽ��Կ��� ���ӽ������� ī�� �ű�� ��Ȳ
//		gameSlot[btn] = gameSlot[btn1];
//		gameSlot[btn1] = 0;
		
		// ù �� ���� �˻�
		if(userList.get(whosTurn).getFirstTurn()==0) {
			firstTurn();
		}else if(userList.get(whosTurn).getFirstTurn()==1) {
		
	
		
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
						//����//
					}
				}else if(gameSlot[i+1]==-1) {
					if(cardGroup>=3) {
						//������ ����//
					}else {
						//����//
					}
				}
			}//for j
		}//for i
		}//if(for firstTurn)
		whosTurn++;
	}//play


	public void firstTurn() {
		
		int btn = 0; //��ư ���ؼ� ���� ��Ʈ��(���Թ�ȣ)
		if(userList.get(whosTurn).getUserSlotList().get(btn).getNum()
		+userList.get(whosTurn).getUserSlotList().get(btn).getNum()
		+userList.get(whosTurn).getUserSlotList().get(btn).getNum()>=30) {
			//������ ����//
		}else {
			//����//
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
		
		// ī�� ���� Ȯ�ο� �ڵ�
		for (int i = 0; i < cardList.size(); i++) {
			System.out.print(cardList.get(i).getColor() + " ");
			System.out.print(cardList.get(i).getNum() + " ");
			System.out.println(cardList.get(i).getIndex());
		}//for

		System.out.println("ī��� �� " + cardList.size() + "��");

	}// makeCard

	public void setGame() {
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
	}// setGame

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
