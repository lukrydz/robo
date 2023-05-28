package com.example.musicapi.controller;

import com.example.musicapi.model.AlbumDto;
import com.example.musicapi.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<AlbumDto> getAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public AlbumDto getAlbumById(@PathVariable Long id){
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public void createAlbum(@RequestBody AlbumDto albumDto){
        albumService.createAlbum(albumDto);
    }

    @PutMapping("/{id}")
    public void updateAlbum(@RequestBody AlbumDto albumDto, @PathVariable Long id){
        albumService.updateAlbum(id, albumDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id){
        albumService.deleteAlbum(id);
    }
}
