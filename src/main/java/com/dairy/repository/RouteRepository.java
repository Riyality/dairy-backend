package com.dairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairy.entity.Branch;
import com.dairy.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

	List<Route> getByBranch(Branch branch);
}
