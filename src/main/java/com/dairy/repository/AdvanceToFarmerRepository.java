package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.AdvanceToFarmer;

@Repository
public interface AdvanceToFarmerRepository extends JpaRepository<AdvanceToFarmer, Long> {

}
