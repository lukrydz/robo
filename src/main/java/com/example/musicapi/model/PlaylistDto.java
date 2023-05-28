package com.example.musicapi.model;

import com.example.musicapi.entity.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PlaylistDto {

    private Long id;
    private String name;
    private Set<Song> setOfSongs = new HashSet<>();

}
