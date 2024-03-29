package com.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
	List<Branch> findAll();

	Branch findBranchById(int id);

	

	
}

