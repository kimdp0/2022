package com.sglink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipment {

	@Id
	private String equiId;

	@Column(nullable = false)
	private String equiName;

	private String equUniname;

	private String content;
	@OneToOne
	@JoinColumn(name="img")
	private FileEntity file;

	@ManyToOne
	@JoinColumn
	private Member member;

}
