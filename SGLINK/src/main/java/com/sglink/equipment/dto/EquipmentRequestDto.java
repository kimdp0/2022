package com.sglink.equipment.dto;

import com.sglink.entity.Company;
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
public class EquipmentRequestDto {

	private String equiId;

	private String equiName;

	private String equUniname;

	private String equiContent;
	
	private Company company;
	
	private FileEntity file;

	
	public Equipment toEntity() {
		return Equipment.builder()
				.equiId(equiId)
				.equiName(equiName)
				.equUniname(equUniname)
				.equiContent(equiContent)
				.company(company)
				.file(file) 
				.build();
	}
	
}
