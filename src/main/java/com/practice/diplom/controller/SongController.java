package com.practice.diplom.controller;

import com.practice.diplom.dto.SongRequestDto;
import com.practice.diplom.dto.SongResponseDto;
import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.dto.UrlRequest;
import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.service.SongService;
import com.practice.diplom.service.TabService;
import com.practice.diplom.service.UserSongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/song")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Песни", description = "Методы для работы с песнями и табулатурами")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private UserSongService userSongService;

    @Autowired
    private TabService tabService;

    @GetMapping("/all")
    @Operation(summary = "Получение список всех песен")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public Page<SongResponseDto> getAllSongs(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return songService.getAllSongs(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение песни по Id")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public SongResponseDto getSongById(@PathVariable @Parameter(description = "id песни") Long id) {
        return songService.getSongDtoById(id);
    }


    @PostMapping("/new")
    @Operation(summary = "Создание песни")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public SongResponseDto createSong(@Valid @RequestBody SongRequestDto songResponseDto) {
        return songService.createSong(songResponseDto);
    }

    @PostMapping("/userSong/new")
    @Operation(summary = "Создание песни пользователя для добавления в личный кабинет")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public UserSongResponseDto createUserSong(@Valid @RequestBody UserSongRequestDto userSongRequestDto) {
        return userSongService.createUserSong(userSongRequestDto);
    }

    @GetMapping("/userSong/{id}/all")
    @Operation(summary = "Получение списка песен добавленных пользователем")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public Page<UserSongResponseDto> getAllUserSongs(
            @PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable @Parameter(description = "id пользователя") Long id) {
        return userSongService.getAllUserSongsByUserId(id, pageable);
    }

    @PostMapping("/generate")
    @Operation(summary = "Генерация табулатурefefы")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<TabRequestDto> getGeneratedTabs(@Valid @RequestBody UrlRequest url) {
        System.out.println("HELLLLLLLLLLLLLLLLO");
        return tabService.generateTabs(url);
    }
}
