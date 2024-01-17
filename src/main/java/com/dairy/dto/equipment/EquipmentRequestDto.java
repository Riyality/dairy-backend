package com.dairy.dto.equipment;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRequestDto {
	private Long id;
	@NotBlank(message = "equipment Name cannot be blank")
	@Size(max=32,message = "maximum allowed characters are 32")
	private String name;
	private LocalDateTime dateOfPurchase;
	private Integer quantity;
	private Float price;
	private Float totalAmount;
	private int branchId;
}
