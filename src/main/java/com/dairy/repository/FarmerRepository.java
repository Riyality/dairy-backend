package com.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

	List<Farmer> findAllByStatusAndBranch( String status, Branch branch );
}
