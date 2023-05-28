package com.example.musicapi.model.songdto;

import com.example.musicapi.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSongResponse {

    private Long idR;
    private String titleR;
    private int durationInSecondsR;
    private Genre genreR;
}
