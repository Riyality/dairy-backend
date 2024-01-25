package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.DairyMangerUpdate;
@Repository
public interface DairyMangerUpdatesRepository extends JpaRepository<DairyMangerUpdate, Long> {

}
