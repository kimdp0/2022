package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;




@Data
@Entity
public class FileBoard extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long uid;
	@Column(nullable = false)
	private String title;
	private String content;
	@Column(nullable = false)
	private String writer;
	
	@Builder
	 public FileBoard(Long uid, String title, String content, String writer) {
	    
	 this.uid = uid;
	 this.title = title; 
	 this.content = content; 
	 this.writer = writer; }
	 

}
