package com.sglink.dto;

import com.sglink.entity.NoticeBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeBoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private String registerId;
	
	public NoticeBoard toEntity() {
		return NoticeBoard.builder()
				.title(title)
				.content(content)
				.registerId(registerId)
				.build();
	}

}
