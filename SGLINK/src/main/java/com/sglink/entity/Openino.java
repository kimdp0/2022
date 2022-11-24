package com.sglink.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="openino")
public class Openino extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String title;
	private String content;
	private int readCnts;
	
	
	@Builder
	public Openino(Long id, String title, String content, int viewConunt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnts= readCnts;
	
	}
	
}
