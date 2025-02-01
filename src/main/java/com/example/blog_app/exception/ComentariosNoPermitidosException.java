package com.example.blog_app.exception;

public class ComentariosNoPermitidosException extends RuntimeException {
    public ComentariosNoPermitidosException(String mensaje) {
        super(mensaje);
    }
}