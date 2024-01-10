package com.dairy.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairy.dto.equipment.EquipmentRequestDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;
import com.dairy.entity.Equipment;
import com.dairy.entity.Route;
import com.dairy.mapper.route.RouteMapper;
import com.dairy.repository.RouteRepository;
import com.dairy.service.RouteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RouteServiceImpl implements RouteService{

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private RouteMapper routeMapper;
	
	@Override
	public List<RouteResponseDto> getAllRoutes() {
		List<Route> routes = routeRepository.findAll();
		return routeMapper.toList( routes );
	}

	@Override
	public boolean addRoute(RouteRequestDto dto) {
		try {
			Route route = routeMapper.toEntity(dto);
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
			routeRepository.save(route);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
