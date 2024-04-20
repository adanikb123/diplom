package com.practice.diplom.service;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    Page<SongResponseDto> getAllSongs(Pageable pageable);

    Page<SongResponseDto> getAllSongsByAuthor(String author,Pageable pageable);

    SongResponseDto createSong(SongRequestDto songRequestDto);

    Song getSongById(Long id);

    SongResponseDto getSongDtoById(Long id);


}
