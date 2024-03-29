package com.dairy.mapper.route;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.dto.equipment.EquipmentResponseDto;
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;
import com.dairy.entity.Branch;
import com.dairy.entity.Equipment;
import com.dairy.entity.Route;

@Component
public class RouteMapper {

	public Route toEntity( RouteRequestDto routeRequestDto ) {
		
		if ( routeRequestDto == null ) {
			return null;
		}

		Route route = new Route();
		route.setId(routeRequestDto.getId());
		route.setName( routeRequestDto.getName() );
		route.setRemark( routeRequestDto.getRemark() );

		return route;
	}
	
	public RouteResponseDto toRouteResponseDto( Route route ) {
		
		if ( route == null ) {
			return null;
		}

		RouteResponseDto responseDto = new RouteResponseDto();
		responseDto.setId( route.getId() );
		responseDto.setName( route.getName() );
		responseDto.setRemark( route.getRemark() );
		responseDto.setBranchId(route.getBranch().getId());

		return responseDto;
	}
	
	public List<RouteResponseDto> toList( List<Route> list ) {
		List<RouteResponseDto> dtos = new ArrayList<>();
		for ( Route entity : list ) {
			dtos.add( toRouteResponseDto( entity ) );
		}
		return dtos;

	}

	public List<Route> listToentity(List<RouteRequestDto> dtoList) {
		List <Route> route = new ArrayList<>();
		for(RouteRequestDto dto : dtoList) {
			route.add(toEntitylist(dto));
		}
		return route;
	}

	private Route toEntitylist(RouteRequestDto dto) {
		Route r = new Route();
		
		Branch b = new Branch();
		
		r.setId(dto.getId());
		r.setName(dto.getName());
		r.setRemark(dto.getRemark());
		
		b.setId(dto.getBranchId());
		r.setBranch(b);
		return r;
	}

	
	
}
