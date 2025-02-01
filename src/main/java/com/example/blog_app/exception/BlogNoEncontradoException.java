package com.example.blog_app.exception;

public class BlogNoEncontradoException extends RuntimeException {
    public BlogNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}