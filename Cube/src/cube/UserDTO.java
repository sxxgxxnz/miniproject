package cube;

import java.util.ArrayList;

public class UserDTO {
	private String id,pw,email,emailad,birth;
	private ArrayList<CardDTO> userSlotList = new ArrayList<CardDTO>();
	private int firstTurn = 0;
	private int turn;
	private int gender;
	
//	public UserDTO(String id, int turn) {
//		this.id=id;
//		this.turn=turn;
//		
//	}//»ý¼ºÀÚ

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailad() {
		return emailad;
	}

	public void setEmailad(String emailad) {
		this.emailad = emailad;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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
