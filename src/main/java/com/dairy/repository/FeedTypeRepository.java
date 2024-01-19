package com.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.FeedType;

@Repository
public interface FeedTypeRepository extends JpaRepository<FeedType, Long> {

	List<FeedType> findByIdAndBranch(int id, int branchId);

}
