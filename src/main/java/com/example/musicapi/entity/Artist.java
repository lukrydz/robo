package com.example.musicapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String country;

    @OneToMany(mappedBy = "artist")
    private Set<Song> allSongs;

    @OneToMany(mappedBy = "artist")
    private Set<Album> allAlbums;


}
