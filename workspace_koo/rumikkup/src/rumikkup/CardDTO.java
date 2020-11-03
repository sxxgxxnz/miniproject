package rumikkup;

enum Color {RED, BLUE, YELLOW, BLACK, JOKER}

public class CardDTO implements Comparable<CardDTO> {
	private Color color;
	private int num;
	private int index;
	private String pic;


	
	
	public CardDTO(int num, Color color, int index) {
		this.num = num;
		this.color = color;
		this.index = index;
	}



	public String getPic() {
		return pic;
	}



	public void setPic(String pic) {
		this.pic = pic;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	@Override
	public int compareTo(CardDTO s) {
		if (this.index < s.getIndex()) {
            return -1;
        } else if (this.index > s.getIndex()) {
            return 1;
        }
        return 0;

	}



	
	
	
	

	
}
