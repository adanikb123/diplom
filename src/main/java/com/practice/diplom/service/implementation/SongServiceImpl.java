package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.entity.Song;
import com.practice.diplom.entity.Tab;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.SongMapper;
import com.practice.diplom.repository.SongRepository;
import com.practice.diplom.service.SongService;
import com.practice.diplom.service.TabService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private SongMapper songMapper;

    @Autowired
    private TabService tabService;

    @Override
    public List<SongResponseDto> getAllSongs() {
        List<Song> songs = songRepository.findAll();
        return songMapper.toResponseDtos(songs);
    }

    @Override
    public List<SongResponseDto> getAllSongsByAuthor(String author) {
        return null;
    }

    @Override
    @Transactional
    public SongResponseDto createSong(SongRequestDto songRequestDto) {
        Song song = songMapper.toEntity(songRequestDto);


        List<TabRequestDto> tabs = songRequestDto.getTabs();
        for (TabRequestDto tabRequestDto : tabs) {
            Tab tab = tabService.createTab(tabRequestDto);
            tab.setSong(song);
        }
        songRepository.save(song);
        return songMapper.toResponseDto(song);
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).
                orElseThrow(
                        () -> new NotFoundException(String.format("Песня с таким id = %d не существует", id)));
    }

    @Override
    public SongResponseDto getSongDtoById(Long id){
        return songMapper.toResponseDto(getSongById(id));
    }
}
