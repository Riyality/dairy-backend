package com.dairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.MainBranch;

@Repository
public interface MainBranchRepository extends JpaRepository<MainBranch, Long> {

}
