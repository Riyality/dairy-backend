package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.FarmerAnimalMapping;

@Repository
public interface FarmerAnimalMappingRepository extends JpaRepository<FarmerAnimalMapping, Long> {

}
