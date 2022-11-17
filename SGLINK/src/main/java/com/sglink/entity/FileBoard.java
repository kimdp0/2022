package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;




@Data
@Entity
public class FileBoard extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String title;
	private String content;
	@Column(nullable = false)
	private String writer;
	
	
	@OneToOne
	@JoinColumn(name = "registerId")
	private Member member;
	
	
	@Builder
	 public FileBoard(Long id, String title, String content, String writer) {
	    
	 this.id = id;
	 this.title = title; 
	 this.content = content; 
	 this.writer = writer; }
	 

}
