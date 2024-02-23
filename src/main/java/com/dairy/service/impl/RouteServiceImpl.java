package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Route;
import com.dairy.mapper.route.RouteMapper;
import com.dairy.repository.BranchRepository;
import com.dairy.repository.RouteRepository;
import com.dairy.service.RouteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private RouteMapper routeMapper;
	
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public List<RouteResponseDto> getAllRoutes(int branchId) {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if ( branchOptional.isPresent() ) {
			List<Route> routes = routeRepository.getByBranch(branchOptional.get());
			return routeMapper.toList(routes);
		}
		return null;
	}

	@Override
	public boolean addRoute(RouteRequestDto dto) {
		try {
			Route route = routeMapper.toEntity(dto);
			Optional<Branch> opt = branchRepository.findById(dto.getBranchId());
			if (opt.isPresent())
				route.setBranch(opt.get());
			routeRepository.save(route);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public RouteResponseDto findById(int id) {

		Optional<Route> opt = routeRepository.findById(id);
		if (opt.isPresent())
			return routeMapper.toRouteResponseDto(opt.get());
		return null;
	}

	@Override
	public boolean updateRoute(RouteRequestDto dto) {
		try {
			Route route = routeMapper.toEntity(dto);
			Optional<Branch> opt = branchRepository.findById(dto.getBranchId());
			if (opt.isPresent())
				route.setBranch(opt.get());
			routeRepository.save(route);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
