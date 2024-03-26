package com.practice.diplom.mapper;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper extends GeneralMapper<SongRequestDto, Song, SongResponseDto> {
}
