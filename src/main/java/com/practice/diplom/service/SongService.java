package com.practice.diplom.service;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.entity.Song;

import java.util.List;

public interface SongService {
    List<SongResponseDto> getAllSongs();

    List<SongResponseDto> getAllSongsByAuthor(String author);

    SongResponseDto createSong(SongRequestDto songRequestDto);

    Song getSongById(Long id);

    SongResponseDto getSongDtoById(Long id);


}
