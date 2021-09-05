package model.member;

public class MemberVO {
	private int num;
	private String mid;
	private String mpw;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", mid=" + mid + ", mpw=" + mpw + "]";
	}

	
	
	
	
}
