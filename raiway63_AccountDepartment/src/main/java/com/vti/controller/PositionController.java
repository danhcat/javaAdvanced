package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Position;
import com.vti.service.IPositionService;

@RequestMapping(value = "api/v1/position") // http://localhost:8080/api/v1/position
@RestController
@CrossOrigin("*")
public class PositionController {
	@Autowired
	private IPositionService positionService;

	// http://localhost:8080/api/v1/position/getposition
	@GetMapping("/getposition")
	public ResponseEntity<?> getAllPosition() {
		List<Position> positions = positionService.getAllPosition();
		for (Position position : positions) {

		}

		return new ResponseEntity<>(positions, HttpStatus.OK);
	}

}
