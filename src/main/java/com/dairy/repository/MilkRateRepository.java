package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.dto.milkRate.MilkRateRequestDto;
import com.dairy.entity.Branch;
import com.dairy.entity.MilkRate;

@Repository
public interface MilkRateRepository extends JpaRepository<MilkRate, Integer> {

	
	  @Query("SELECT mr FROM MilkRate mr WHERE mr.type = :type AND ROUND(mr.fat, 1) = :fat AND ROUND(mr.snf, 1) = :snf AND mr.branch = :branch")
	    MilkRate findByTypeAndFatAndSnfAndBranch(@Param("type") String type, @Param("fat") float fat, @Param("snf") float snf, @Param("branch") Branch branch);


	void save(MilkRateRequestDto milkRate);

}
