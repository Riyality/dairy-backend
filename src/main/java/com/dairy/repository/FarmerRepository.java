package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;
import com.dairy.entity.Route;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

	List<Farmer> findAllByStatusAndBranch( String status, Branch branch );

	List<Farmer> findAllByStatusAndRouteAndBranch(String status, Route route, Branch branch);

	Optional<Farmer> findByIdAndBranch(Long id, Branch branch);

   
	 @Query("SELECT COUNT(f) FROM Farmer f WHERE f.status = 'active' AND f.branch.id = :branchId")
	 long countActiveFarmersByBranchId(@Param("branchId") int branchId);


	 @Query("SELECT COUNT(f) FROM Farmer f WHERE f.status = 'inActive' AND f.branch.id = :branchId")
	 long countInActiveFarmersByBranchId(@Param("branchId") int branchId);


}
