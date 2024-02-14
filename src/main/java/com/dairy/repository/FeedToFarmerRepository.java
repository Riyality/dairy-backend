package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	  
	
	
//	 @Modifying
//	    @Query("UPDATE FeedToFarmer SET remainingAmount = :remainingAmount WHERE farmer.id = :farmerId")
//	    void updateRemainingAmount(@Param("farmerId") Long farmerId, @Param("remainingAmount") Float remainingAmount);
//






	List<FeedToFarmer> findAllByFarmerId(Long farmerId);



	FeedToFarmer findByFarmerId(Long farmerId);
	  
	  
	  //FeedToFarmer findTopByFarmerIdOrderByidDesc(Long farmerId);
//	  
//	  @Query("SELECT f FROM FeedToFarmer f WHERE f.id = (SELECT MAX(f2.id) FROM FeedToFarmer f2 WHERE f2.farmer.id = :farmerId)")
//	    FeedToFarmer findLatestByFarmerId(@Param("farmerId") Long farmerId);
////	  
//	  @Query("SELECT f FROM FeedToFarmer f WHERE f.id = (SELECT MAX(f2.id) FROM FeedToFarmer f2 WHERE f2.farmer.id = :farmerId)")
//	    FeedToFarmer findLatestByFarmerId(@Param("farmerId") Long farmerId);

}
