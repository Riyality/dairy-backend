package com.dairy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.MilkCollection;

@Repository
public interface MilkCollectionRepository extends JpaRepository<MilkCollection, Long>{

	List<MilkCollection> findByBranchAndDateOfCollection(Branch branch, LocalDate dateOfCollection);

}
