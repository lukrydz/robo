package com.example.musicapi.repository;

import com.example.musicapi.entity.Artist;
import com.example.musicapi.entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();

}
