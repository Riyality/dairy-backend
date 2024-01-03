package com.dairy.dto.feedtype;

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
	private Long id;
	private String type;
	private Long feedCompanyId;
}
