package com.dairy.service; 

import java.util.List;

import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;

public interface RouteService {
	
	List<RouteResponseDto> getAllRoutes(int branchId);
	
	boolean addRoute(RouteRequestDto dto);
	
	RouteResponseDto findById( int id );

	boolean updateRoute( RouteRequestDto dto );

	RouteRequestDto saveAllRoute(List<RouteRequestDto> dto);
}
