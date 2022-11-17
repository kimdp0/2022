package com.sglink.dto;

import com.sglink.entity.FileBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileBoardRequestDto {
	
	private Long id;
	private String title;
	private String content;
	private String writer;
	
	public FileBoard toEntity() {
		return FileBoard.builder()
				.title(title)
				.content(content)
				.writer(writer)
				.id(id)
				.build();
	}
	
	
	@Override
	public String toString() {
		return "File_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ "]";
	}

}
