package com.example.musicapi.mapper;

import com.example.musicapi.entity.Song;
import com.example.musicapi.model.songdto.CreateSongResponse;
import com.example.musicapi.model.songdto.UpdateSongResponse;

public class SongMapper {

    public static CreateSongResponse mapSongToCreateSongResponse(Song song) {
        return new CreateSongResponse(
                song.getId(),
                song.getTitle(),
                song.getDurationInSeconds(),
                song.getGenre()
        );
    }

    public static UpdateSongResponse mapSongToUpdateSongResponse(Song song) {
        return new UpdateSongResponse(
                song.getId(),
                song.getTitle(),
                song.getDurationInSeconds(),
                song.getGenre()
        );
    }
}
