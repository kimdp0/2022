package com.sglink.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Business extends BaseTimeEntity {

	@Id
	private String busiId;

	@Column(nullable = false)
	private String busiName;

	private String busiUniname;

	private String busiContent;

	private String busiRegister;

	private String busiTel;

	@Enumerated(EnumType.STRING)
	private Process process;

	@Enumerated(EnumType.STRING)
	private Reservation reservation;

	@OneToMany(mappedBy = "busiImg")
	private List<FileEntity> busiImg;

	@Builder
	public Business(String busiId, String busiName, String busiUniname, String busiContent, String busiRegister,
			String busiTel, List<FileEntity> busiImg) {

		this.busiId = busiId;
		this.busiName = busiName;
		this.busiRegister = busiRegister;
		this.busiTel = busiTel;
		this.busiUniname = busiUniname;
		this.busiContent = busiContent;
		this.busiImg = busiImg;
	}

	@PrePersist
	public void prePersist() {
		this.reservation = this.reservation == null ? Reservation.IMPOSSIBLE : this.reservation;
		this.process = this.process == null ? Process.UNAPPROVE : this.process;
	}

}
