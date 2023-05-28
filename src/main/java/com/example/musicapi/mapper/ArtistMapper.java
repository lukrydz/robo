package com.example.musicapi.mapper;

import com.example.musicapi.entity.Artist;
import com.example.musicapi.model.ArtistDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ArtistMapper {

    ArtistDto mapToArtistDto(Artist artist);

    @InheritInverseConfiguration
    Artist mapToArtist(ArtistDto artistDto);

    List<ArtistDto> mapToArtistDtoList(List<Artist> artists);

    @InheritInverseConfiguration
    List<Artist> mapToArtist(List<ArtistDto> artistDtos);
}
