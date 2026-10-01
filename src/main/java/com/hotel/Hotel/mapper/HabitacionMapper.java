package com.hotel.Hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hotel.Hotel.domain.Habitacion;
import com.hotel.Hotel.domain.HabitacionEstandar;
import com.hotel.Hotel.domain.SuitePresidencial;
import com.hotel.Hotel.dto.response.HabitacionResponse;
import com.hotel.Hotel.dto.response.HabitacionEstandarResponse;
import com.hotel.Hotel.dto.response.SuitePresidencialResponse;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    @Mapping(target = "tipo", constant = "ESTANDAR")
    HabitacionEstandarResponse toResponse(
            HabitacionEstandar habitacionEstandar);

    @Mapping(target = "tipo", constant = "SUITE")
    SuitePresidencialResponse toResponse(
            SuitePresidencial suitePresidencial);

    default HabitacionResponse toResponse(Habitacion habitacion) {

        if (habitacion instanceof HabitacionEstandar estandar) {
            return toResponse(estandar);
        }

        if (habitacion instanceof SuitePresidencial suite) {
            return toResponse(suite);
        }

        throw new IllegalArgumentException(
                "Tipo de habitación no soportado");
    }
}