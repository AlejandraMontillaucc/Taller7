package com.hotel.Hotel.controller;

import com.hotel.Hotel.dto.request.crearHabitacionEstandarRequest;
import com.hotel.Hotel.dto.request.crearSuitePresidencialRequest;
import com.hotel.Hotel.dto.response.HabitacionResponse;
import com.hotel.Hotel.service.HabitacionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping("/estandar")
    public ResponseEntity<HabitacionResponse> crearEstandar(
            @RequestBody crearHabitacionEstandarRequest request) {

        return ResponseEntity.ok(
                habitacionService.crearEstandar(request));
    }

    @PostMapping("/suites")
    public ResponseEntity<HabitacionResponse> crearSuite(
            @RequestBody crearSuitePresidencialRequest request) {

        return ResponseEntity.ok(
                habitacionService.crearSuite(request));
    }

    @GetMapping
    public ResponseEntity<List<HabitacionResponse>> listar() {

        return ResponseEntity.ok(
                habitacionService.listarTodas());
    }
}