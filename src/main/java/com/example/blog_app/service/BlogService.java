package com.example.blog_app.service;

import com.example.blog_app.exception.BlogNoEncontradoException;
import com.example.blog_app.exception.ComentariosNoPermitidosException;
import com.example.blog_app.model.Blog;
import com.example.blog_app.model.Comentario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BlogService {

    private Map<String, Blog> blogs = new HashMap<>();

    public Blog crearBlog(Blog blog) {
        blog.setId(UUID.randomUUID().toString());
        blogs.put(blog.getId(), blog);
        return blog;
    }

    public List<Blog> obtenerTodosLosBlogs() {
        return new ArrayList<>(blogs.values());
    }

    public Blog actualizarBlog(String id, Blog blog) {
        if (!blogs.containsKey(id)) {
            throw new BlogNoEncontradoException("Blog no encontrado");
        }
        Blog blogActual = blogs.get(id);
        List<Comentario> comentariosExistentes = blogActual.getComentarios();
        List<Blog> historicoVersiones = blogActual.getHistoricoVersiones();
        
        blogActual.agregarVersion(new Blog(blogActual));
        blog.setId(id);
        blog.setComentarios(comentariosExistentes);
        blog.setHistoricoVersiones(historicoVersiones);
        blogs.put(id, blog);
        return blog;
    }

    public Blog obtenerBlog(String id) {
        if (!blogs.containsKey(id)) {
            throw new BlogNoEncontradoException("Blog no encontrado");
        }
        return blogs.get(id);
    }

    public Comentario agregarComentario(String id, Comentario comentario) {
        Blog blog = obtenerBlog(id);
        if (!blog.isPermiteComentarios()) {
            throw new ComentariosNoPermitidosException("El blog no permite comentarios");
        }
        comentario.setId(UUID.randomUUID().toString());
        blog.getComentarios().add(comentario);
        return comentario;
    }
}