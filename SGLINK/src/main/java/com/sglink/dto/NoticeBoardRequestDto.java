package com.sglink.dto;

import com.sglink.entity.Member;
import com.sglink.entity.NoticeBoard;

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
	
	public NoticeBoard toEntity() {
		return NoticeBoard.builder()
				.title(title)
				.content(content)
				.member(member)
				.build();
	}
	
//	@Override
//	public String toString() {
//		return "Notice_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", member=" + member
//				+ "]";
//	}

}
