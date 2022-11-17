package com.sglink.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sglink.dto.NoticeBoardRequestDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name= "board")
public class Board extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	@Column(nullable = true, length = 1000)
	private String content;
	private int readCnt;
	private String boardName;
	
	@OneToOne
	@JoinColumn(name = "registerId")
	private Member member;
	
	
	
	@Builder
	public Board(Long id, String title, String content, int readCnt, Member member, String boardName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.member = member;
		this.boardName= boardName;
	}
	
//	public static Board createNoticeBoard(NoticeBoardRequestDto noticeboardRequestDto) {
//		Board board= new Board();
//		board.setId(noticeboardRequestDto.getId());
//		board.setTitle(noticeboardRequestDto.getTitle());
//		board.setContent(noticeboardRequestDto.getContent());
//		board.setMember(noticeboardRequestDto.getMember());
//		
//		
//		return board;
//	}
	

}
