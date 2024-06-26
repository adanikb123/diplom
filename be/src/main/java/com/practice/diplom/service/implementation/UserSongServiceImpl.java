package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.entity.Song;
import com.practice.diplom.entity.User;
import com.practice.diplom.entity.UserSong;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.UserSongMapper;
import com.practice.diplom.repository.UserSongRepository;
import com.practice.diplom.service.SongService;
import com.practice.diplom.service.UserService;
import com.practice.diplom.service.UserSongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSongServiceImpl implements UserSongService {

    @Autowired
    private UserSongMapper userSongMapper;
    @Autowired
    private UserSongRepository userSongRepository;

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @Override
    public Page<UserSongResponseDto> getAllUserSongsByUserId(Long id, Pageable pageable) {
        Page<UserSong> userSongs = userSongRepository.findAllByUserId(id,pageable);
        return userSongs.map(userSongMapper::toResponseDto);
    }

    @Override
    public UserSongResponseDto createUserSong(UserSongRequestDto songRequestDto) {
        UserSong userSong = userSongMapper.toEntity(songRequestDto);

        Long userId = songRequestDto.getUserId();
        User user = userService.getUserById(userId);
        userSong.setUser(user);

        Long songId = songRequestDto.getSongId();
        Song song = songService.getSongById(songId);
        userSong.setSong(song);

        userSongRepository.save(userSong);
        return userSongMapper.toResponseDto(userSong);
    }
}
