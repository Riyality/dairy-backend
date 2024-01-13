package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.FeedToFarmer;

@Repository
public interface FeedToFarmerRepository extends JpaRepository<FeedToFarmer, Long>{

}
