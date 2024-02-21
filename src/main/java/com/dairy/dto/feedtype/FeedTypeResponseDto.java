package com.dairy.dto.feedtype;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedTypeResponseDto {

	private Long id;
	@NotBlank(message = "feed type cannot be blank")
	private String type;
	private Long feedcompanyId;
	private String feedCompanyName;
	private int branchId;
	private String remark;
}
