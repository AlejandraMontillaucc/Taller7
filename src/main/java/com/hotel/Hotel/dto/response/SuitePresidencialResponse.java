package com.hotel.Hotel.dto.response;

public class SuitePresidencialResponse extends HabitacionResponse {
    private boolean incluyeMayordomo;
    private boolean jacuzziPrivado;

    public boolean isIncluyeMayordomo() {
        return incluyeMayordomo;
    }

    public boolean isJacuzziPrivado() {
        return jacuzziPrivado;
    }

    public void setIncluyeMayordomo(boolean incluyeMayordomo) {
        this.incluyeMayordomo = incluyeMayordomo;
    }

    public void setJacuzziPrivado(boolean jacuzziPrivado) {
        this.jacuzziPrivado = jacuzziPrivado;
    }
}