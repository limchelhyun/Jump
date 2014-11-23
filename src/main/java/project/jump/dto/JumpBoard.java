package project.jump.dto;

import java.util.Date;

public class JumpBoard {
	private String jumpId;
	private int boardNum;
	private Date boardDate;
	private String boardTitle;
	private String boardArea;
	private String boardContent;
	private int boardBest;
	
	public int getBoardBest() {
		return boardBest;
	}
	public void setBoardBest(int boardBest) {
		this.boardBest = boardBest;
	}
	public String getBoardArea() {
		return boardArea;
	}
	public void setBoardArea(String boardArea) {
		this.boardArea = boardArea;
	}	
	public String getJumpId() {
		return jumpId;
	}
	public void setJumpId(String jumpId) {
		this.jumpId = jumpId;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
}
