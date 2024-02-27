package com.dairy.dto.feedtype;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedTypeRequestDto {
	private long id;
	@NotBlank(message = "feed type cannot be blank")
	private String type;
	private long feedCompanyId;
	private int branchId;
	private String remark;
}
