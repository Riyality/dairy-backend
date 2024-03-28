package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedToFarmer;

@Repository
public interface FeedToFarmerRepository extends JpaRepository<FeedToFarmer, Long>{
	
	@Query("SELECT SUM(ftf.remainingAmount) FROM FeedToFarmer ftf " +
		       "WHERE ftf.farmer.id = :farmerId AND ftf.branch.id = :branchId " +
		       "AND ftf.dateOfPurchase BETWEEN :fromDate AND :toDate")
		Double findTotalOfRemainingAmountByFarmerIdAndBranchId(
		        @Param("farmerId") long farmerId,
		        @Param("branchId") int branchId,
		        @Param("fromDate") LocalDate fromDate,
		        @Param("toDate") LocalDate toDate);

	List<FeedToFarmer> findAllByFarmerId(Long farmerId);

	FeedToFarmer findByFarmerId(Long farmerId);

	

	List<FeedToFarmer> findByDateOfPurchaseBetweenAndBranchId(@Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("branchId") int branchId);

	List<FeedToFarmer> findByDateOfPurchaseBetweenAndBranchIdAndFarmer(LocalDate fromDate, LocalDate toDate,
			int branchId, Optional<Farmer> farmer);

	
	

	List<FeedToFarmer> findByDateOfPurchaseBetweenAndBranchIdAndFeedCompany(LocalDate fromDate, LocalDate toDate,
			int branchId, Optional<FeedCompany> feedCompanyOpt);

	List<FeedToFarmer> findByBranch(Branch branch);
	  
	  
}
