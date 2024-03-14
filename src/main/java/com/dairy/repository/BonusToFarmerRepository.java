package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.BonusToFarmer;
import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;

@Repository
public interface BonusToFarmerRepository extends JpaRepository<BonusToFarmer, Integer> {

	// List<BonusToFarmer> findAllBonusRecord(Branch branch);
	 @Query("SELECT b FROM BonusToFarmer b WHERE b.branch = :branch")
	    List<BonusToFarmer> findAllBonusRecord(@Param("branch") Branch branch);

	List<BonusToFarmer> findByBonusDateBetweenAndBranchAndFarmer(LocalDate fromDate, LocalDate toDate, Branch branch,
			Optional<Farmer> farmer);

	List<BonusToFarmer> findByBonusDateBetweenAndBranch(LocalDate fromDate, LocalDate toDate, Branch branch);
	

}
