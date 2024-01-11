package com.dairy.dto.branch;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponseDto {
	private int id;
	
	@NotBlank(message = "Branch Name cannot be blank")
    @Size(max = 32, message = "maximum allowed characters are 32")
	private String name;
	
	@Size(max = 128, message = "Address must be at most 128 characters")
	private String address;
	
	@NotBlank(message = "Owner cannot be blank")
    @Size(max = 32, message = "Owner must be at most 32 characters")
	private String owner;
	
	@NotBlank(message = "Owner Contact cannot be blank")
    @Size(max = 10, message = "Owner Contact must be at most 10 characters")
	private String ownerContact;
	
	private LocalDateTime startDate;
}
