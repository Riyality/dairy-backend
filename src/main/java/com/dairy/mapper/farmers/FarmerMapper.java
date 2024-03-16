package com.dairy.mapper.farmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dairy.dto.bankdetails.BankRequestDto;
import com.dairy.dto.bankdetails.BankResponseDto;
import com.dairy.dto.employee.EmployeeResponseDto;
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.farmers.FarmerResponseDto;
import com.dairy.entity.Bank;
import com.dairy.entity.Branch;
import com.dairy.entity.Employee;
import com.dairy.entity.Farmer;
import com.dairy.entity.Route;
import com.dairy.mapper.bank.BankMapper;
import com.dairy.mapper.route.RouteMapper;
import com.dairy.repository.BankRepository;

@Component
public class FarmerMapper {

	@Autowired
	private BankMapper bankMapper;
	
	@Autowired
	private RouteMapper routeMapper;

	public Farmer toEntity( FarmerRequestDto requestDto ) {
		Farmer farmer = new Farmer();
		farmer.setId( requestDto.getId() );
		farmer.setName( requestDto.getName() );
		farmer.setDateOfRegistration( requestDto.getDateOfRegistration() );
	
		farmer.setContact( requestDto.getContact() );
		farmer.setAddress( requestDto.getAddress() );
		farmer.setStatus(requestDto.getStatus());
		farmer.setRemark(requestDto.getRemark());

		return farmer;
	}

	public FarmerResponseDto toResponseDto( Farmer farmer ) {
		FarmerResponseDto responseDto = new FarmerResponseDto();
		responseDto.setId( farmer.getId() );
		responseDto.setName( farmer.getName() );
		responseDto.setDateOfRegistration( farmer.getDateOfRegistration() );
		responseDto.setContact( farmer.getContact() );
		responseDto.setAddress( farmer.getAddress() );
		responseDto.setStatus( farmer.getStatus() );
		responseDto.setRemark(farmer.getRemark());
		responseDto.setBranchId(farmer.getBranch().getId());
		if ( farmer.getRoute() != null ) {
			responseDto.setRoute( routeMapper.toRouteResponseDto( farmer.getRoute() ) );
		}
		
		if ( farmer.getBank() != null ) {
			responseDto.setBank( bankMapper.toBankResponseDto( farmer.getBank() ) );
		}

		return responseDto;
	}

//	private BankResponseDto tobank(Bank bank) {
//		BankResponseDto bankdto = new BankResponseDto();
//		
//		bankdto.setAccountNumber(bank.getAccountNumber());
//		bankdto.setBankName(bank.getBankName());
//		bankdto.setBranchId(bank.getBranch().getId());
//		bankdto.setBranchName(bank.getBranchName());
//		bankdto.setUpiId(bank.getUpiId());
//		bankdto.setIfscCode(bank.getIfscCode());
//		bankdto.setId(bank.getId());
//		
//		return bankdto;
//	}

	public List<FarmerResponseDto> toList( List<Farmer> farmerList ) {
		return farmerList.stream()
				.map( this::toResponseDto )
				.collect( Collectors.toList() );
	}
	

	public List<Farmer> listToentity(List<FarmerRequestDto> dto) {
		List<Farmer> farmer = new ArrayList<>();
		
		for (FarmerRequestDto entity : dto) {
			farmer.add(toEntitySave(entity));
		}
		return farmer;
	}

	private Farmer toEntitySave(FarmerRequestDto entity) {
		Farmer farmer = new Farmer();
		Branch b = new Branch();
		Route r = new Route();
		Bank bank = new Bank();
		farmer.setId( entity.getId() );
		farmer.setName( entity.getName() );
		farmer.setDateOfRegistration( entity.getDateOfRegistration() );
	
		farmer.setContact( entity.getContact() );
		farmer.setAddress( entity.getAddress() );
		farmer.setStatus(entity.getStatus());
		farmer.setRemark(entity.getRemark());
		b.setId(entity.getBranchId());
		farmer.setBranch(b);
		r.setId(entity.getRoute());
		farmer.setRoute(r);
		bank.setId(entity.getId());
		farmer.setBank(bank);		
		return farmer;
	}
}
