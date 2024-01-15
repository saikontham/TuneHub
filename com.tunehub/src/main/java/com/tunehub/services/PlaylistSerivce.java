package com.tunehub.services;

import com.tunehub.entities.Playlist;

import java.util.List;

public interface PlaylistSerivce {
    public void addPlaylist(Playlist playlist);

    public List<Playlist> fetchPlaylist();
}
