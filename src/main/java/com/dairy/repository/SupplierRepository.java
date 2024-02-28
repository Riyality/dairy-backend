package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Supplier;

@Repository
public interface SupplierRepository  extends JpaRepository<Supplier, Long>{

	List<Supplier> findByBranch(Branch branch);

	Optional<Supplier> findByIdAndBranch(Long id, Branch branch);

}
