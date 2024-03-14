
package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedDetails;
import com.dairy.entity.FeedType;

@Repository
public interface FeedDetailsRepository extends JpaRepository<FeedDetails, Integer>{

	Optional<FeedDetails> findByFeedCompanyIdAndFeedTypeId(long feedCompanyId, long feedTypeId);

	Optional<FeedDetails> findByFeedTypeAndFeedCompanyAndBranch(Optional<FeedType> feedTypeOpt,
			Optional<FeedCompany> feedCompanyOpt, Optional<Branch> branchOpt);

	 @Query("SELECT SUM(f.quantity) FROM FeedStock f WHERE f.branch.id = :branchId")
	  int getTotalQuantityByBranch( @Param("branchId")int branchId);

	 @Query("SELECT fd.quantity FROM FeedDetails fd WHERE fd.feedType.id = :feedTypeId AND fd.feedCompany.id = :feedCompanyId AND fd.branch.id = :branchId")
	 long getFeedQuantityByFeedTypeFeedCompanyAndBranch(long feedTypeId, long feedCompanyId, int branchId);

	List<FeedDetails> findByBranch(Branch branch);


	



}
