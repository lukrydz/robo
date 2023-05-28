package com.example.musicapi.mapper;


import com.example.musicapi.entity.Playlist;
import com.example.musicapi.model.PlaylistDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    PlaylistDto mapToPlaylistDto(Playlist playlist);

    @InheritInverseConfiguration
    Playlist mapToPlaylist(PlaylistDto playlistDto);

    List<PlaylistDto> mapToPlaylistDto(List<Playlist> playlistList);

    @InheritInverseConfiguration
    List<Playlist> mapToPlaylist(List<PlaylistDto> playlistListDto);
}
