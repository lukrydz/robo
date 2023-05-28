package com.example.musicapi.service;

import com.example.musicapi.entity.Song;
import com.example.musicapi.mapper.SongMapper;
import com.example.musicapi.model.songdto.CreateSongRequest;
import com.example.musicapi.model.songdto.CreateSongResponse;
import com.example.musicapi.model.songdto.UpdateSongRequest;
import com.example.musicapi.model.songdto.UpdateSongResponse;
import com.example.musicapi.repository.SongRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public CreateSongResponse createSong(CreateSongRequest request) {
        Song song = Song.builder()
                .title(request.getTitleR())
                .durationInSeconds(request.getDurationInSecondsR())
                .genre(request.getGenreR())
                .build();
        songRepository.save(song);

        return SongMapper.mapSongToCreateSongResponse(song);
    }

    public List<CreateSongResponse> getSongsList() {
        return songRepository.findAll()
                .stream().map(song -> SongMapper.mapSongToCreateSongResponse(song))
                .toList();
    }

    public CreateSongResponse getSongById(Long songId) {
        return songRepository.findById(songId)
                .stream().map(song -> SongMapper.mapSongToCreateSongResponse(song))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Song not found"));
    }

    public UpdateSongResponse updateSong(Long songId, UpdateSongRequest request) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new EntityNotFoundException("Song not found"));
        song.setDurationInSeconds(request.getDurationInSecondsR());
        song.setGenre(request.getGenreR());

        song = songRepository.save(song);

        return SongMapper.mapSongToUpdateSongResponse(song);

    }

    public void deleteSongById (Long songId) {
        try {
            songRepository.deleteById(songId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Song not found");
        }
    }

}
