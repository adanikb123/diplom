package com.practice.diplom.controller;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.service.SongService;
import com.practice.diplom.service.UserSongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/song")
@Tag(name = "Песни",description = "Методы для работы с песнями и табулатурами")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private UserSongService userSongService;

    @GetMapping("/all")
    @Operation(summary = "Получение список всех песен")
    public List<SongResponseDto> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение песни по Id")
    public SongResponseDto getSongById(@PathVariable  @Parameter(description = "id песни") Long id){
        return songService.getSongDtoById(id);
    }


    @PostMapping("/new")
    @Operation(summary = "Создание песни")
    public SongResponseDto createSong(@Valid @RequestBody SongRequestDto songResponseDto){
        return songService.createSong(songResponseDto);
    }

    @PostMapping("/userSong/new")
    @Operation(summary = "Создание песни пользователя для добавления в личный кабинет")
    public UserSongResponseDto createUserSong(@Valid @RequestBody UserSongRequestDto userSongRequestDto){
        return userSongService.createUserSong(userSongRequestDto);
    }

    @GetMapping("/userSong/{id}/all")
    @Operation(summary = "Получение списка песен добавленных пользователем")
    public List<UserSongResponseDto> getAllUserSongs(@PathVariable @Parameter(description = "id пользователя") Long id){
        return userSongService.getAllUserSongsByUserId(id);
    }

}
