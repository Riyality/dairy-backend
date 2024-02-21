package com.dairy.dto.mainBranch;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MainBranchRequestDto {
	private Long id;
    private String name;
	private LocalDateTime dateOfCollection;
	private String shift;
	private String type;
	private Float quantity;
	private Float fat;
	private Float snf;
	private Float protein ;
	private Float rate;
	private Float totalAmount;
	private String remark;

}
