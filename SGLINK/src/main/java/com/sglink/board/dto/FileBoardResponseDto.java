package com.sglink.board.dto;

import java.time.LocalDateTime;

import com.sglink.entity.FileBoard;
import com.sglink.entity.Member;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
public class FileBoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private Member member;
	private LocalDateTime registerTime;
	private int readCnt;
	
	public FileBoardResponseDto(FileBoard entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.member = entity.getMember();
		this.registerTime = entity.getRegisterTime();
		this.readCnt = entity.getReadCnt();
	}
	 
	
	
	
	

}
