package com.dairy.dto.dairyManger;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DairyManagerRequestDto {
	private Long id;
	private String name;
	private Integer personId;
	private LocalDateTime dateTransaction;
	private String transactionType;
	private String contact;
	private Long amount;
	private String remark;
}
