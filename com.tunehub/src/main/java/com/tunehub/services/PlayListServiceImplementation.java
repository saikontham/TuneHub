package com.tunehub.services;

import com.tunehub.entities.Playlist;
import com.tunehub.entities.Songs;
import com.tunehub.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListServiceImplementation implements PlaylistSerivce{

    @Autowired
    private PlaylistRepository playlistRepository;
    @Override
    public void addPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);


    }

    @Override
    public List<Playlist> fetchPlaylist() {
        return playlistRepository.findAll();
    }
}
