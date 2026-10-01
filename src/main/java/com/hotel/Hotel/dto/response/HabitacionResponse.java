package com.hotel.Hotel.dto.response;

import java.util.UUID;

public abstract class HabitacionResponse {
    private UUID id;
    private String numero;
    private double precioPorNoche;
    private int capacidadMaxima;
    private String estado;
    private String tipo;

    public HabitacionResponse() {

    }

    public UUID getid() {
        return id;
    }

    public String getnumero() {
        return numero;
    }

    public double getprecioPorNoche() {
        return precioPorNoche;
    }

    public int getcapacidadMaxima() {
        return capacidadMaxima;
    }

    public String getestado() {
        return estado;
    }

    public String gettipo() {
        return tipo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
