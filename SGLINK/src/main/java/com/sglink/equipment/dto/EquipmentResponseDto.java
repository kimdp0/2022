package com.sglink.equipment.dto;

import java.util.List;

import com.sglink.entity.Equipment;
import com.sglink.entity.FileEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class EquipmentResponseDto {

	private String equiName;

	private String equiUniname;
	
	private String equiContent;
	
	private String equiRegister;
	
	private List<FileEntity> img;
	
	public EquipmentResponseDto(Equipment entity) {
		this.equiName=entity.getEquiName();
		this.equiUniname=entity.getEquiUniname();
		this.equiContent=entity.getEquiContent();
	}
}
