package com.rest.tp3.web.controller;

import com.rest.tp3.dao.IAlbumDAO;
import com.rest.tp3.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
public class AlbumController {

    private final IAlbumDAO dao;

    @Autowired
    public AlbumController(@Qualifier("albumDAO") IAlbumDAO dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/Albums")
    public Collection<Album> getAlbums(HttpServletResponse response) {
        Collection<Album> album = dao.get();
        if (album.isEmpty())
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return album;
    }

    @GetMapping(value = "/Albums/{id}")
    public Album getAlbum(@PathVariable int id, HttpServletResponse response) {
        Album album = dao.get(id);
        if (album == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return album;
    }

    @DeleteMapping(value = "/Albums/{id}")
    public void deleteAlbum(@PathVariable int id, HttpServletResponse response) {
        if (!dao.delete(id)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }

    @PostMapping(value = "/Albums")
    public Album postAlbum(@RequestBody Album album) {
        return dao.post(album);
    }

    @PutMapping(value = "/Albums/{id}")
    public Album putAlbum(@PathVariable int id, @RequestBody Album album, HttpServletResponse response) {
        Album modifiedAlbum = dao.put(id, album);
        if(modifiedAlbum == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }else{
            return modifiedAlbum;
        }
    }
}
