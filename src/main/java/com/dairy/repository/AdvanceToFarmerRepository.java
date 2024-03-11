package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.AdvanceToFarmer;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;

@Repository
public interface AdvanceToFarmerRepository extends JpaRepository<AdvanceToFarmer, Long> {

	
	@Query("SELECT a.remainingAmount FROM AdvanceToFarmer a " +
	        "WHERE a.farmer.id = :farmerId AND a.branch.id = :branchId")
	Double findTotalOfRemainingAmountByFarmerIdAndBranchId(
	        @Param("farmerId") Long farmerId,
	        @Param("branchId") Integer branchId);

	Optional<AdvanceToFarmer> findByFarmerId(Long farmerId);

	List<AdvanceToFarmer> findByBranch(Branch branch);

	Optional<AdvanceToFarmer> findByIdAndBranch(long id, Branch branch);

	List<AdvanceToFarmer> findByDateOfAdvanceBetweenAndBranch(LocalDate fromDate, LocalDate toDate, Branch branch);

	List<AdvanceToFarmer> findByDateOfAdvanceBetweenAndBranchAndFarmer(LocalDate fromDate, LocalDate toDate,
			Branch branch, Optional<Farmer> farmer);
}
