package com.example.musicapi.controller;


import com.example.musicapi.model.PlaylistDto;
import com.example.musicapi.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<PlaylistDto> getAllPlaylist() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public PlaylistDto getById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping()
    public void savePlaylist(PlaylistDto playlistDto) {
        playlistService.createPlaylist(playlistDto);
    }

    @PutMapping("/{id}")
    public void updatePlaylist(@PathVariable Long id, @RequestBody PlaylistDto playlistDto) {
        playlistService.updatePlaylist(id, playlistDto);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}
