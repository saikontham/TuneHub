package com.tunehub.services;

import com.tunehub.entities.Playlist;
import com.tunehub.entities.Songs;

import java.util.List;

public interface SongService {
    public void addSong(Songs songs);
    public void updateSong(Songs songs);


    public List<Songs> viewallsongs();

    public boolean songExists(String name,String artist);

    public List<Songs> playsongs();

//    public List<Songs> playsongs();


}
