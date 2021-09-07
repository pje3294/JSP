package model.member;

/*
 * -- 회원 테이블
create table member(
   mnum int primary key,
    mid varchar(15) not null,
    mpw varchar(15) not null
);
 * */
public class MemberVO {
	private int mnum;
	private String mid;
	private String mpw;
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
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
		return "MemberVO [mnum=" + mnum + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
	
	
}
