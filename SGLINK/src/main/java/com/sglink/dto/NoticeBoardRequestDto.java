package com.sglink.dto;

import com.sglink.entity.Member;
import com.sglink.entity.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class NoticeBoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private Member member;
	private String boardName;
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.member(member)
				.boardName(boardName)
				.build();
	}

//	@Override
//	public String toString() {
//		return "Notice_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", member=" + member
//				+ "]";
//	}

}
