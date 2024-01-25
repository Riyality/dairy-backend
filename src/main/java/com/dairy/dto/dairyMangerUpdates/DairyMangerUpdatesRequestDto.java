package com.dairy.dto.dairyMangerUpdates;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DairyMangerUpdatesRequestDto {
	private Long id;
	private LocalDateTime dateTransaction;
	private String transactionType;
	private Float balance;
	private String remark;
	private Long dairyMangerId;

}
