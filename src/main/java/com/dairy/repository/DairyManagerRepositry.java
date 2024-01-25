package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.DairyManger;

@Repository
public interface DairyManagerRepositry extends JpaRepository<DairyManger, Long> {


}
