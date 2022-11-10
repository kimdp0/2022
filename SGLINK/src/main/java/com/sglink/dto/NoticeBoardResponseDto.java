package com.sglink.dto;

import java.time.LocalDate;

import com.sglink.entity.NoticeBoard;

import lombok.Getter;

@Getter
public class NoticeBoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private String registerId;
	private LocalDate registerTime;
	
	public NoticeBoardResponseDto(NoticeBoard entity) {
		this.id =entity.getId();
		this.title= entity.getTitle();
		this.content = entity.getContent();
		this.readCnt= entity.getReadCnt();
		this.registerId= entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
	}
	@Override
	public String toString() {
		return "Notice_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
						+ ", registerId=" + registerId + ", registerTime=" + registerTime + "]";
	}

}
