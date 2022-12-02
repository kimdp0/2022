package com.sglink.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

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
public class EquipmentReservation{

	@Id
	private String equiId;

	@Column(nullable = false)
	private String equiName;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Member member;

	@Enumerated(EnumType.STRING)
	private Reservation reservation;
	
	private Date startDate;
	private Date endDate;

	@Builder
	public EquipmentReservation(String equiId, String equiName ,Member member,Date startDate,Date endDate) {

		this.equiId = equiId;
		this.equiName = equiName;
		this.member = member;
		this.startDate = startDate;
		this.endDate  = endDate;
	}

	@PrePersist
	public void prePersist() {
		this.reservation = this.reservation == null ? Reservation.IMPOSSIBLE : this.reservation;
	}

}
