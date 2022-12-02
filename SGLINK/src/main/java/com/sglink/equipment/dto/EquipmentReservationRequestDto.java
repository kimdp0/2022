package com.sglink.equipment.dto;

import java.util.Date;

import com.sglink.entity.EquipmentReservation;
import com.sglink.entity.Member;

public class EquipmentReservationRequestDto {
	private String equiId;
	private String equiName;
	private Member member;
	private Date startDate;
	private Date endDate;
	
	public EquipmentReservation toEntity() {
		return EquipmentReservation.builder()
				.equiId(equiId)
				.equiName(equiName)
				.member(member)
				.startDate(startDate)
				.endDate(endDate)
				.build();
	}
	

}
