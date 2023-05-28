package com.example.musicapi.controller;

import com.example.musicapi.model.songdto.CreateSongRequest;
import com.example.musicapi.model.songdto.CreateSongResponse;
import com.example.musicapi.model.songdto.UpdateSongRequest;
import com.example.musicapi.model.songdto.UpdateSongResponse;
import com.example.musicapi.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;


    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping()
    public CreateSongResponse createSong(@RequestBody CreateSongRequest request) {
        return songService.createSong(request);
    }

    @GetMapping()
    public List<CreateSongResponse> getSongsList() {
        return songService.getSongsList();
    }

    @GetMapping("/{songId}")
    public CreateSongResponse getSongById(@PathVariable Long songId) {
        return songService.getSongById(songId);
    }

    @PutMapping("/{songId}")
    public UpdateSongResponse updateSong(@PathVariable Long songId, @RequestBody UpdateSongRequest request) {
        return songService.updateSong(songId, request);
    }

    @DeleteMapping("/{songId}")
    public void deleteSongById(@PathVariable Long songId) {
        songService.deleteSongById(songId);
    }


}
