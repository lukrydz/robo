package com.example.musicapi.mapper;

import com.example.musicapi.entity.Album;
import com.example.musicapi.model.AlbumDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AlbumMapper {

    AlbumDto mapToAlbumDto(Album album);

    @InheritInverseConfiguration
    Album mapToAlbum(AlbumDto albumDto);

    List<AlbumDto> mapToAlbumDtoList(List<Album> albums);

    @InheritInverseConfiguration
    List<Album> mapToAlbum(List<AlbumDto> albumDtos);




}
