package com.dairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dairy.constants.MessageConstants;
import com.dairy.dto.branch.BranchRequestDto;
import com.dairy.dto.branch.BranchResponseDto;
import com.dairy.dto.farmers.FarmerRequestDto;
import com.dairy.dto.route.RouteRequestDto;
import com.dairy.dto.route.RouteResponseDto;
import com.dairy.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@PostMapping
	public ResponseEntity<String> addRoute(@RequestBody RouteRequestDto dto) {

		boolean isAdded = routeService.addRoute(dto);
		
		if (isAdded)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_ROUTE_SUCCESS_MESSAGE);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_ROUTE_ERROR_MSG);
	}

	@GetMapping("all/{branchId}")
	public ResponseEntity<List<RouteResponseDto>> getAllRoutes(@PathVariable int branchId) {
		return new ResponseEntity<>(routeService.getAllRoutes(branchId), HttpStatus.OK);
	}
	

	@GetMapping( "/{id}" )
	public ResponseEntity<RouteResponseDto> findById( @PathVariable int id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( routeService.findById( id ) );
	}

	@PutMapping
	public ResponseEntity<String> updateRoute( @RequestBody RouteRequestDto dto ) {
		
		boolean isUpdated = routeService.updateRoute( dto );
		
		if ( isUpdated )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.UPDATE_ROUTE_SUCCESS_MESSAGE );
		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.UPDATE_ROUTE_ERROR_MSG );
	}
	
	 @PostMapping("/saveAllRoutes")
		public ResponseEntity<RouteRequestDto> saveAllRouteList(@RequestBody List<RouteRequestDto> dto) {
		 RouteRequestDto RouteRequestDto = routeService.saveAllRoute(dto);
		   
		    if (RouteRequestDto != null) {
		        return ResponseEntity.status(HttpStatus.CREATED).body(RouteRequestDto);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
		}

}
