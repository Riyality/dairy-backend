package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.dto.milkRate.MilkRateRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.MilkRate;

@Repository
public interface MilkRateRepository extends JpaRepository<MilkRate, Integer> {

	MilkRate findByTypeAndFatAndSnfAndBranch(String type, float fat, float snf, Branch branch);


	void save(MilkRateRequestDto milkRate);

}
