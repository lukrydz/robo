package com.example.musicapi.repository;

import com.example.musicapi.entity.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findAll();

}
