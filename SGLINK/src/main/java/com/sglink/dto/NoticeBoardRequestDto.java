package com.sglink.dto;

import com.sglink.entity.noticeBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class noticeBoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private String registerId;
	
	public noticeBoard toEntity() {
		return noticeBoard.builder()
				.title(title)
				.content(content)
				.registerId(registerId)
				.build();
	}

}
