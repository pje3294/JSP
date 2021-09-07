package model.board;

import java.sql.Date;

/*
 *  게시판 테이블  
 *  create table board(
	bnum int primary key,
	id varchar(20) not null,
	title varchar(20) not null,
	content varchar(50) not null,
	wdate date default sysdate
);
 */

public class BoardVO {
	private int bnum;
	private String id;
	private String title;
	private String content;
	private Date bdate;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", id=" + id + ", title=" + title + ", content=" + content + ", bdate=" + bdate
				+ "]";
	}
	
	
	
	
}
