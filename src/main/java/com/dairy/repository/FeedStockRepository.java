package com.dairy.repository;

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

}