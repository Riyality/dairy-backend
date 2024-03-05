
package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.FeedStock;

@Repository
public interface FeedStockRepository extends JpaRepository<FeedStock, Integer>{

	List<FeedStock> findByBranch(Branch branch);

	Optional<FeedStock> findByIdAndBranch(int id, Branch branch);
  
   @Query("SELECT SUM(f.quantity) FROM FeedStock f WHERE f.branch.id = :branchId")
	  int getTotalQuantityByBranch( @Param("branchId")int branchId);


}