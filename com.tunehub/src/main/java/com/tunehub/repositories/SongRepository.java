package com.tunehub.repositories;

import com.tunehub.entities.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Songs,Integer> {
    public Songs findByName(String name);


    public Songs findByNameAndArtist(String name, String artist);
}
