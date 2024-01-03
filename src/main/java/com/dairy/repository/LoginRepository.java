package com.dairy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {

	Login findByUsername( String username );

}
