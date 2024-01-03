package com.dairy.dto.branch;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponseDto {
	private int id;
	private String name;
	private String address;
	private String owner;
	private String ownerContact;
	private LocalDateTime startDate;
}
