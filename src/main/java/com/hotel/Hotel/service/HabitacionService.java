package com.hotel.Hotel.service;

import com.hotel.Hotel.domain.Habitacion;
import com.hotel.Hotel.domain.HabitacionEstandar;
import com.hotel.Hotel.domain.SuitePresidencial;
import com.hotel.Hotel.dto.request.crearHabitacionEstandarRequest;
import com.hotel.Hotel.dto.request.crearSuitePresidencialRequest;
import com.hotel.Hotel.dto.response.HabitacionResponse;
import com.hotel.Hotel.mapper.HabitacionMapper;
import com.hotel.Hotel.repository.HabitacionRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

    public HabitacionService(
            HabitacionRepository habitacionRepository,
            HabitacionMapper habitacionMapper) {

        this.habitacionRepository = habitacionRepository;
        this.habitacionMapper = habitacionMapper;
    }

    @Transactional
    public HabitacionResponse crearEstandar(crearHabitacionEstandarRequest request) {

        HabitacionEstandar habitacion = new HabitacionEstandar(
                request.numero(),
                request.capacidadMaxima(),
                request.precioPorNoche(),
                request.camasIndividuales());

        Habitacion guardada = habitacionRepository.save(habitacion);

        return habitacionMapper.toResponse(guardada);
    }

    @Transactional
    public HabitacionResponse crearSuite(crearSuitePresidencialRequest request) {

        SuitePresidencial suite = new SuitePresidencial(
                request.numero(),
                request.capacidadMaxima(),
                request.precioPorNoche(),
                request.incluyeMayordomo(),
                request.jacuzziPrivado());

        Habitacion guardada = habitacionRepository.save(suite);

        return habitacionMapper.toResponse(guardada);
    }

    @Transactional(readOnly = true)
    public List<HabitacionResponse> listarTodas() {

        return habitacionRepository.findAll()
                .stream()
                .map(habitacionMapper::toResponse)
                .toList();
    }
}