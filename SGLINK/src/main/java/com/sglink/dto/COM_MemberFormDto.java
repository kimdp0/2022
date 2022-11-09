package com.sglink.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class COM_MemberFormDto {
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String comuserid;

	@NotBlank(message = "담당자이름은 필수 입력 값입니다.")
	private String comusername;

	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String comuseremail;

	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	@Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
	private String comuserpw;
	
	@NotEmpty(message = "비밀번호확인은 필수 입력 값입니다.")
	@Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
	private String comuserpw2;
	
	@AssertTrue(message = "비밀번호와 비밀번호확인이 일치하지 않습니다.")
	public Boolean CheckPw() {
		if(this.comuserpw == this.comuserpw2) {
			return false;
		}
		return false;
	}
	

	@NotBlank(message = "기관명은 필수 입력 값입니다.")
	private String comuseruniname;

	@Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "Invalid. Not the form XXX-XXXX-XXX: ")
	private String comusertel;
	
	
}