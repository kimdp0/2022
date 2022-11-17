package com.sglink.dto;

import com.sglink.entity.FileBoard;

public class FileBoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private String writer;
	
	public FileBoardResponseDto(FileBoard entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.writer = entity.getWriter();
		
	}
	 
	
	@Override
	public String toString() {
		return "File_BoardResponsetDto [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ "]";
	}
	
	

}
