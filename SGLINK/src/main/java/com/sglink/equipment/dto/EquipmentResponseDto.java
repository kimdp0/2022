package com.sglink.equipment.dto;

import java.util.List;

import com.sglink.entity.Equipment;
import com.sglink.entity.FileEntity;
import com.sglink.common.constant.Process;
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
	
	private String equiTel;
	
	private List<FileEntity> img;
	
	private Process process;
	
	public EquipmentResponseDto(Equipment entity) {
		this.equiName=entity.getEquiName();
		this.equiRegister=entity.getEquiRegister();
		this.equiTel=entity.getEquiTel();
		this.equiUniname=entity.getEquiUniname();
		this.equiContent=entity.getEquiContent();
		this.img=entity.getImg();
		this.process =entity.getProcess();
	}
}
