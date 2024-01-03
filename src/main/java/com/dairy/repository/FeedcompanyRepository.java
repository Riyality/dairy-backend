package com.dairy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dairy.entity.FeedCompany;
import com.sun.mail.imap.protocol.ID;


@Repository
public interface FeedcompanyRepository extends CrudRepository<FeedCompany, Long> {
	
	List<FeedCompany> findAll();

}
