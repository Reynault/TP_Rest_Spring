package com.rest.tp3.dao;

import com.rest.tp3.model.Album;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AlbumDAO implements IAlbumDAO {
    private int maxid;
    private Map<Integer, Album> albums;

    public AlbumDAO() {
        maxid = 0;
        this.albums = new HashMap<>();
        maxid ++;
        this.albums.put(maxid, new Album(
                maxid,
                "An Awesome Wave",
                "Iguana Studio",
                Arrays.asList("Alt J"),
                19.99f,
                40
        ));
        maxid++;
        this.albums.put(maxid, new Album(
                maxid,
                "The Golden Age",
                "Green United Music",
                Arrays.asList("Woodkid"),
                24.99f,
                200
        ));
        maxid++;
        this.albums.put(maxid, new Album(
                maxid,
                "Myopia",
                "Strange Harvest Limited",
                Arrays.asList("Agnes Obel"),
                1999.99f,
                2
        ));
    }

    @Override
    public Album post(Album album) {
        maxid++;
        album.setId(maxid);
        albums.put(maxid, album);
        return album;
    }

    @Override
    public boolean delete(int id) {
        if (contains(id)) {
            albums.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Album put(int id, Album album) {
        if (contains(id)) {
            album.setId(id);
            albums.put(id, album);
            return album;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Album> get() {
        return albums.values();
    }

    @Override
    public Album get(int id) {
        return albums.get(id);
    }

    @Override
    public boolean contains(int id) {
        return albums.containsKey(id);
    }
}
