package com.dairy.service; 

import java.util.List;

import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;

public interface RouteService {
	
	List<RouteResponseDto> getAllRoutes();
	
	boolean addRoute(RouteRequestDto dto);
	
	RouteResponseDto findById( int id );

	boolean updateRoute( RouteRequestDto dto );
}
