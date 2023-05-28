package com.example.musicapi.service;

import com.example.musicapi.entity.Artist;
import com.example.musicapi.mapper.ArtistMapper;
import com.example.musicapi.model.ArtistDto;
import com.example.musicapi.repository.ArtistRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    public ArtistService(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    public ArtistDto createArtist(ArtistDto artistDto){
        Artist artist = artistRepository.save(artistMapper.mapToArtist(artistDto));
        return artistMapper.mapToArtistDto(artist);
    }

    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }

    public void updateArtist(Long id, ArtistDto artistDto){
        Optional<Artist> artistOptional = artistRepository.findById(id);
        artistOptional.ifPresentOrElse(artist -> {
            artist.setName(artistDto.getName());
            artist.setCountry(artistDto.getCountry());
            artistRepository.save(artist);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + "not found");
        });
    }

    public List<ArtistDto> getAllArtists(){
        return artistMapper.mapToArtistDtoList(artistRepository.findAll());
    }

    public ArtistDto getArtistById(Long id){
        Artist artist = artistRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Artist does not found"));
        return artistMapper.mapToArtistDto(artist);
    }
}
