package com.dairy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.FeedCompany;
import com.sun.mail.imap.protocol.ID;


@Repository
public interface FeedcompanyRepository extends CrudRepository<FeedCompany, Long> {
	
	List<FeedCompany> findAll();

	Optional<FeedCompany> findByIdAndBranch(Long id, Branch branch);

	List<FeedCompany> findByBranch(Branch branch);

}
