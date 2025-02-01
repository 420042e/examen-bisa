package com.example.blog_app.model;

public class ResumenPuntuaciones {
    private int minima;
    private int maxima;
    private double promedio;

    public ResumenPuntuaciones(int minima, int maxima, double promedio) {
        this.minima = minima;
        this.maxima = maxima;
        this.promedio = promedio;
    }

    public int getMinima() {
        return minima;
    }

    public int getMaxima() {
        return maxima;
    }

    public double getPromedio() {
        return promedio;
    }
}