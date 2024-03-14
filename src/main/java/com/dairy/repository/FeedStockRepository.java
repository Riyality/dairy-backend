
package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.dairy.entity.FeedStock;
import com.dairy.entity.FeedType;

@Repository
public interface FeedStockRepository extends JpaRepository<FeedStock, Integer>{

	List<FeedStock> findByBranch(Branch branch);

	Optional<FeedStock> findByIdAndBranch(int id, Branch branch);
  
   @Query("SELECT SUM(f.quantity) FROM FeedStock f WHERE f.branch.id = :branchId")
	  int getTotalQuantityByBranch( @Param("branchId")int branchId);

   
   Optional<FeedStock> findByFeedTypeAndFeedCompanyAndBranch(Optional<FeedType> feedTypeOpt,
		Optional<FeedCompany> feedCompanyOpt, Optional<Branch> branchOpt);





}
