package com.dairy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.AdvanceToFarmer;

@Repository
public interface AdvanceToFarmerRepository extends JpaRepository<AdvanceToFarmer, Long> {

	
	@Query("SELECT a.remainingAmount FROM AdvanceToFarmer a " +
	        "WHERE a.farmer.id = :farmerId AND a.branch.id = :branchId")
	Double findTotalOfRemainingAmountByFarmerIdAndBranchId(
	        @Param("farmerId") Long farmerId,
	        @Param("branchId") Integer branchId);


	
	Optional<AdvanceToFarmer> findByFarmerId(Long farmerId);
}
