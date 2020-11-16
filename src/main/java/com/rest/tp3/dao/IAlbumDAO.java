package com.rest.tp3.dao;

import com.rest.tp3.model.Album;

import java.util.Collection;

public interface IAlbumDAO {
    boolean delete(int id);

    Album put(int id, Album album);

    Album post(Album album);

    Collection<Album> get();

    Album get(int id);

    boolean contains(int id);
}

