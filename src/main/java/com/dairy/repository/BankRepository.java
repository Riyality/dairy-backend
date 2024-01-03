package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
