package com.example.blog_app.controller;

import com.example.blog_app.model.Blog;
import com.example.blog_app.model.Comentario;
import com.example.blog_app.service.BlogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> crearBlog(@RequestBody Blog blog) {
        Blog nuevoBlog = blogService.crearBlog(blog);
        return new ResponseEntity<>(nuevoBlog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> obtenerTodosLosBlogs() {
        List<Blog> todosLosBlogs = blogService.obtenerTodosLosBlogs();
        return new ResponseEntity<>(todosLosBlogs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> actualizarBlog(@PathVariable String id, @RequestBody Blog blog) {
        Blog blogActualizado = blogService.actualizarBlog(id, blog);
        return new ResponseEntity<>(blogActualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> obtenerBlog(@PathVariable String id) {
        Blog blog = blogService.obtenerBlog(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<Comentario> agregarComentario(@PathVariable String id, @RequestBody Comentario comentario) {
        Comentario nuevoComentario = blogService.agregarComentario(id, comentario);
        return new ResponseEntity<>(nuevoComentario, HttpStatus.CREATED);
    }
}