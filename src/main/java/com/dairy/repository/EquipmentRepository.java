package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>  {

	List<Equipment> findByBranch(Branch branch);

	Optional<Equipment> findByIdAndBranch(long id, Branch branch);


}
