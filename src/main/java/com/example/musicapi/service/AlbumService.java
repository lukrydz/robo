package com.example.musicapi.service;

import com.example.musicapi.entity.Album;
import com.example.musicapi.model.AlbumDto;
import com.example.musicapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public Album createAlbum(AlbumDto albumDto) {
        return new Album(
                albumDto.getId(),
                albumDto.getTitle(),
                albumDto.getReleaseData());
    }

    public void saveAlbum(AlbumDto albumDto) {
        Album album = createAlbum(albumDto);
        repository.save(album);
    }

    public void deleteAlbum(Album album) {
        repository.deleteById(album.getId());
    }

    public void updateAlbum(AlbumDto albumDto) {
        Album album = repository.findById(
                albumDto.getId())
                .orElseThrow(() -> new RuntimeException("Album does not exist"));
        album.setTitle(album.getTitle());
        album.setReleaseData(albumDto.getReleaseData());
        repository.save(album);
    }

    public List<Album> getAllAlbums() {
        return repository.findAll();
    }

    public AlbumDto getAlbumById(Long id) {
        Album album = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album does not exist"));
        return new AlbumDto(album.getId(),
                album.getTitle(),
                album.getReleaseData());
    }


}
