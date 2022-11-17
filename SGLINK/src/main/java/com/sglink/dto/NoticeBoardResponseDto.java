package com.sglink.dto;

import java.time.LocalDateTime;

import com.sglink.entity.Member;
import com.sglink.entity.Board;

import lombok.Getter;

@Getter
public class NoticeBoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private Member member;
	private LocalDateTime registerTime;
	
	public NoticeBoardResponseDto(Board entity) {
		this.id =entity.getId();
		this.title= entity.getTitle();
		this.content = entity.getContent();
		this.readCnt= entity.getReadCnt();
		this.member= entity.getMember();
		this.registerTime = entity.getRegisterTime();
	}
	@Override
	public String toString() {
		return "Notice_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
						+ ", registerId=" + member + ", registerTime=" + registerTime + "]";
	}

}
