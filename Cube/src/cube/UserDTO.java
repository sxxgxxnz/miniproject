package cube;

import java.util.ArrayList;

public class UserDTO {
	private String id;
	private ArrayList<CardDTO> userSlotList = new ArrayList<CardDTO>();
	private int firstTurn = 0;
	private int turn;
	
//	public UserDTO(String id, int turn) {
//		this.id=id;
//		this.turn=turn;
//		
//	}//»ý¼ºÀÚ

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<CardDTO> getUserSlotList() {
		return userSlotList;
	}

	public void setUserSlotList(ArrayList<CardDTO> userSlotList) {
		this.userSlotList = userSlotList;
	}

	public int getFirstTurn() {
		return firstTurn;
	}

	public void setFirstTurn(int firstTurn) {
		this.firstTurn = firstTurn;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}
