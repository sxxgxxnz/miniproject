package cube;

//버튼 컬러 바꾸기 위해 enum이름 바껐어요
enum Colorcard{RED, BLUE, YELLOW, BLACK, JOKER}

public class CardDTO{
	private Colorcard color;
	private int num;
	private int index;
	private String pic;
	public Colorcard getColor() {
		return color;
	}
	public void setColor(Colorcard color) {
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}