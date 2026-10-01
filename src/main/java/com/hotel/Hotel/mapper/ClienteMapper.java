package com.hotel.Hotel.mapper;

import com.hotel.Hotel.domain.Cliente;
import com.hotel.Hotel.domain.Reserva;
import com.hotel.Hotel.dto.request.CrearClienteRequest;
import com.hotel.Hotel.dto.response.ClienteResponse;
import com.hotel.Hotel.dto.response.ClienteResumenResponse;
import com.hotel.Hotel.dto.response.ReservaItemResponse;
import com.hotel.Hotel.dto.request.ActualizarClienteRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteResponse toResponse(Cliente cliente);

    List<ClienteResponse> toResponseList(List<Cliente> clientes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "penalizaciones", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Cliente toEntity(CrearClienteRequest request);

    default ClienteResumenResponse toResumen(Cliente cliente) {

        List<ReservaItemResponse> reservas = cliente.getReservas()
                .stream()
                .map(this::toReservaItem)
                .toList();

        int totalReservas = reservas.size();

        double montoTotal = reservas.stream()
                .mapToDouble(ReservaItemResponse::costoTotal)
                .sum();

        return new ClienteResumenResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.isActivo(),
                cliente.getPenalizaciones(),
                totalReservas,
                montoTotal,
                reservas);
    }

    default ReservaItemResponse toReservaItem(Reserva reserva) {

        return new ReservaItemResponse(
                reserva.getId(),
                reserva.getHabitacion().getNumero(),
                reserva.getPeriodo().fechaInicio(),
                reserva.getPeriodo().fechaFin(),
                reserva.getEstado(),
                reserva.getCostoTotal());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "penalizaciones", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    void actualizarCliente(
            ActualizarClienteRequest request,
            @MappingTarget Cliente cliente);
}