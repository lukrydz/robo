package com.example.musicapi.mapper;

import com.example.musicapi.entity.Album;
import com.example.musicapi.model.AlbumDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    AlbumDto mapToAlbumDto(Album album);

    @InheritInverseConfiguration
    Album mapToAlbum(AlbumDto albumDto);

    List<AlbumDto> mapToAlbumDtoList(List<Album> albums);

    @InheritInverseConfiguration
    List<Album> mapToAlbumList(List<AlbumDto> albumDtos);

}
