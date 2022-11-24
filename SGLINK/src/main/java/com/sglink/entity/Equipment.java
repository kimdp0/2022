package com.sglink.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Equipment extends BaseTimeEntity{

	@Id
	private String equiId;

	@Column(nullable = false)
	private String equiName;

	private String equiUniname;

	private String equiContent;
	
	private String equiRegister;

	@OneToMany(mappedBy="img")
	private List<FileEntity> img;

	@OneToMany(mappedBy = "equipment")
	private List<Member> member;


	@Builder
	public Equipment(String equiId, String equiName, String equiUniname, String equiContent, 
			String equiRegister,List<FileEntity> img, List<Member> member) {

		this.equiId = equiId;
		this.equiName = equiName;
		this.equiRegister = equiRegister;
		this.equiUniname = equiUniname;
		this.equiContent = equiContent;
		this.img = img;
		this.member = member;
	}

}
