package com.example.musicapi.repository;

import com.example.musicapi.entity.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findAll();

}
