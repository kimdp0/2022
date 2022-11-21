package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name= "file_board")
public class FileBoard extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String title;
	private String content;
	private int readCnt;
	
	
	@OneToOne
	@JoinColumn(name = "registerId")
	private Member member;
	
	
	@Builder
	 public FileBoard(Long id, String title, String content, Member member, int readCnt) {
	    
	 this.id = id;
	 this.title = title; 
	 this.content = content; 
	 this.member = member; 
	 this.readCnt = readCnt;
	}

}
