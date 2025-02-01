package com.example.blog_app.model;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private String id;
    private String titulo;
    private String tema;
    private String contenido;
    private Periodicidad periodicidad;
    private boolean permiteComentarios;
    private Autor autor;
    private List<Comentario> comentarios = new ArrayList<>();
    private List<Blog> historicoVersiones = new ArrayList<>();

    public Blog() {}

    public Blog(Blog blog) {
        this.id = blog.id;
        this.titulo = blog.titulo;
        this.tema = blog.tema;
        this.contenido = blog.contenido;
        this.periodicidad = blog.periodicidad;
        this.permiteComentarios = blog.permiteComentarios;
        this.autor = blog.autor;
        this.comentarios = new ArrayList<>(blog.comentarios);
        this.historicoVersiones = new ArrayList<>(blog.historicoVersiones);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public boolean isPermiteComentarios() {
        return permiteComentarios;
    }

    public void setPermiteComentarios(boolean permiteComentarios) {
        this.permiteComentarios = permiteComentarios;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Blog> getHistoricoVersiones() {
        return historicoVersiones;
    }

    public void setHistoricoVersiones(List<Blog> historicoVersiones) {
        this.historicoVersiones = historicoVersiones;
    }

    public void agregarVersion(Blog version) {
        this.historicoVersiones.add(version);
    }

    public ResumenPuntuaciones getResumenPuntuaciones() {
        if (comentarios.isEmpty()) {
            return new ResumenPuntuaciones(0, 0, 0);
        }
        int min = comentarios.stream().mapToInt(Comentario::getPuntuacion).min().orElse(0);
        int max = comentarios.stream().mapToInt(Comentario::getPuntuacion).max().orElse(0);
        double promedio = comentarios.stream().mapToInt(Comentario::getPuntuacion).average().orElse(0);
        return new ResumenPuntuaciones(min, max, promedio);
    }
}