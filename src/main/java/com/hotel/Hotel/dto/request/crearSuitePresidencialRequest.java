package com.hotel.Hotel.dto.request;

public record crearSuitePresidencialRequest(
        String numero,
        double precioPorNoche,
        int capacidadMaxima,
        boolean incluyeMayordomo,
        boolean jacuzziPrivado) {
}