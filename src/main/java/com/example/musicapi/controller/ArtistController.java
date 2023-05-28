package com.example.musicapi.controller;

import com.example.musicapi.model.ArtistDto;
import com.example.musicapi.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<ArtistDto> getAllArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistDto getById(@PathVariable Long id){
        return artistService.getArtistById(id);
    }

    @PostMapping
    public void saveArtist(ArtistDto artistDto){
        artistService.createArtist(artistDto);
    }

    @PutMapping("/{id}")
    public void updateArtist(@PathVariable Long id, @RequestBody ArtistDto artistDto){
        artistService.updateArtist(id, artistDto);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id){
        artistService.deleteArtist(id);
    }
}
