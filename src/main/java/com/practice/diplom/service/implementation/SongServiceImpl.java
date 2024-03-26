package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.entity.Song;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.SongMapper;
import com.practice.diplom.repository.SongRepository;
import com.practice.diplom.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private SongMapper songMapper;
    @Override
    public List<SongResponseDto> getAllSongs() {
        return null;
    }

    @Override
    public List<SongResponseDto> getAllSongsByAuthor(String author) {
        return null;
    }

    @Override
    public SongResponseDto createSong(SongRequestDto songRequestDto) {
        return null;
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).
                orElseThrow(
                        ()-> new NotFoundException(String.format("Пользователь с таким id = %d не существует",id)));
    }
}
