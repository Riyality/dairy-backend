package com.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.BonusToFarmer;
import com.dairy.entity.Branch;

@Repository
public interface BonusToFarmerRepository extends JpaRepository<BonusToFarmer, Integer> {

	// List<BonusToFarmer> findAllBonusRecord(Branch branch);
	 @Query("SELECT b FROM BonusToFarmer b WHERE b.branch = :branch")
	    List<BonusToFarmer> findAllBonusRecord(@Param("branch") Branch branch);
	

}
