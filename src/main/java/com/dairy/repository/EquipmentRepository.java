package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>  {


}
