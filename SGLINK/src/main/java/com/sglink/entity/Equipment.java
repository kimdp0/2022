package com.sglink.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.sglink.common.constant.Process;
import com.sglink.common.constant.Reservation;

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
	
	private String equiTel;
	
	@Enumerated(EnumType.STRING)
	private Process process;
	
	@Enumerated(EnumType.STRING)
	private Reservation reservation;

	@OneToMany(mappedBy="img")
	private List<FileEntity> img;

	@OneToMany(mappedBy = "equipment")
	private List<Member> member;


	@Builder
	public Equipment(String equiId, String equiName, String equiUniname, String equiContent, 
			String equiRegister, String equiTel, List<FileEntity> img, List<Member> member) {

		this.equiId = equiId;
		this.equiName = equiName;
		this.equiRegister = equiRegister;
		this.equiTel = equiTel;
		this.equiUniname = equiUniname;
		this.equiContent = equiContent;
		this.img = img;
		this.member = member;
	}

	 @PrePersist
	    public void prePersist() {
	        this.reservation = this.reservation == null ? Reservation.IMPOSSIBLE : this.reservation;
	        this.process = this.process == null ? Process.UNAPPROVE : this.process;
	    }
	 

}
