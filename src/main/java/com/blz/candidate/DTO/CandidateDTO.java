package com.blz.candidate.DTO;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CandidateDTO {
//
//	@NotBlank(message = "cisid cannot be empty")
	private String cicId;

//	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Fullname Invalid")
	private String fullName;

//	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message ="Enter valid email address")
	private String email;

//	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Enter valid mobile number")
	private String mobileNum;

//	@NotBlank(message = "Hireddate cannot be empty")
	private String hiredDate;

//	@Pattern(regexp="Bsc|Bcom|BE|Btech|Mtech|Msc",message="invalid degree")
	private String degree;

	private Double aggrPer;

//	@Pattern(regexp = "^[A-Z]{1,}[a-z]{3,}$", message = "City name should start with uppercase and having atleast 4 characters!")
	private String city;

//	@Pattern(regexp = "^[A-Z]{1,}[a-z]{1,}$", message = "State name should start with uppercase and having atleast 2 characters!")
	private String state;

//	@NotBlank(message = "Preffered location cannot be empty")
	private String preferredJobLocation;

//	@Pattern(regexp="Completed|Dropped|Inprogress|Remapped",message="invalid status")
	private String status;
//
//	@NotBlank(message = "Passed out year cannot be empty")
	private String passedOutYear;

//	@NotBlank(message = "Creater user cannot be empty")
	private String creatorUser;

//	@Pattern(regexp="Married|Single",message="invalid candidate status")
	private String candidateStatus;

	private LocalDateTime creationTimeStamp;

	private LocalDateTime updatedTimeStamp;
}
