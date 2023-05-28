package com.example.musicapi.service;


import com.example.musicapi.entity.Playlist;
import com.example.musicapi.mapper.PlaylistMapper;
import com.example.musicapi.model.PlaylistDto;
import com.example.musicapi.repository.PlaylistRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    public PlaylistService(PlaylistRepository playlistRepository, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.playlistMapper = playlistMapper;
    }

    public PlaylistDto createPlaylist(PlaylistDto playlistDto) {
        Playlist playlist = playlistRepository.save(playlistMapper.mapToPlaylist(playlistDto));
        return playlistMapper.mapToPlaylistDto(playlist);
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }


    public void updatePlaylist(Long id, PlaylistDto playlistDto) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(id);
        playlistOptional.ifPresentOrElse(playlist -> {
            playlist.setName(playlistDto.getName());
            playlist.setSetOfSongs(playlistDto.getSetOfSongs());
            playlistRepository.save(playlist);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    public List<PlaylistDto> getAllPlaylists() {
        return playlistMapper.mapToPlaylistDto(playlistRepository.findAll());
    }

    public PlaylistDto getPlaylistById(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" Playlist not found"));
        return playlistMapper.mapToPlaylistDto(playlist);
    }

}
