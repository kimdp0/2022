package com.sglink.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
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

	private String equiContent;

	@OneToOne
	@JoinColumn(name = "img")
	private FileEntity file;

	@OneToMany(mappedBy = "equipment")
	private List<Member> member;

	@ManyToOne
	@JoinColumn
	private Company company;

	@Builder
	public Equipment(String equiId, String equiName, String equUniname, String equiContent, FileEntity file, List<Member> member,
			Company company) {

		this.equiId = equiId;
		this.equiName = equiName;
		this.equUniname = equUniname;
		this.equiContent = equiContent;
		this.file = file;
		this.member = member;
		this.company = company;
	}

}
