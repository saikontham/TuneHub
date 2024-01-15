package com.tunehub.services;

import com.tunehub.entities.Songs;
import com.tunehub.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImplementation implements SongService{
    @Autowired
    SongRepository songRepository;

    /**addSong: Method to add a new song to the database.
     Songs songs: Takes a Songs object as a parameter representing the new song to be added.
     songRepository.save(songs): Uses Spring Data JPA's save method to persist the new song to the database.
     This method essentially saves a new song entity to the database using the Spring Data JPA repository's save method.
     **/
    @Override
    public void addSong(Songs songs) {
        songRepository.save(songs);
    }

    @Override
    public void updateSong(Songs songs) {
        songRepository.save(songs);
    }

    /**
     * Retrieves a list of all songs from the database.
     *
     * @return List of Songs representing all songs in the database.
     */
    @Override
    public List<Songs> viewallsongs() {
        return songRepository.findAll();
    }


    /**
     * Checks if a song with a given name and artist already exists in the database.
     *
     * @param name   The name of the song.
     * @param artist The artist of the song.
     * @return True if the song already exists, false otherwise.
     */
    @Override
    public boolean songExists(String name, String artist) {
        Songs existingSong = songRepository.findByNameAndArtist(name, artist);

        return existingSong != null;
    }

    @Override
    public List<Songs> playsongs() {
        return null;
    }

}
