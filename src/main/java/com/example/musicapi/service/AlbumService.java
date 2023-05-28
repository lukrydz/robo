package com.example.musicapi.service;

import com.example.musicapi.entity.Album;
import com.example.musicapi.mapper.AlbumMapper;
import com.example.musicapi.model.AlbumDto;
import com.example.musicapi.repository.AlbumRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumMapper albumMapper;
    private final AlbumRepository repository;

    public AlbumDto createAlbum(AlbumDto albumDto) {
        Album album = repository.save(albumMapper.mapToAlbum(albumDto));
        return albumMapper.mapToAlbumDto(album);

    }

    public void deleteAlbum(Album album) {
        repository.deleteById(album.getId());
    }
        //shift + ctrl + f
        // 2x shift     <- intellij search
    public void updateAlbum(Long id, AlbumDto albumDto) {

        Optional<Album> albumOptional = repository.findById(id);
        albumOptional.ifPresentOrElse(album -> {
            album.setTitle(album.getTitle());
            album.setReleaseData(albumDto.getReleaseData());
            repository.save(album);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    public List<AlbumDto> getAllAlbums() {
        return albumMapper.mapToAlbumDtoList(repository.findAll());
    }

    public AlbumDto getAlbumById(Long id) {
        Album album = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album does not exist"));
        return albumMapper.mapToAlbumDto(album);
    }


}
