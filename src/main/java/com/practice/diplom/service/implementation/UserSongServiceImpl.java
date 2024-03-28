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
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserSongResponseDto> getAllUserSongsByUserId(Long id) {
        userService.checkid(id);
        List<UserSong> userSongs = userSongRepository.findAllByUserId(id);
        return userSongMapper.toResponseDtos(userSongs);
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

    @Override
    public void checkId(Long id) {
        if (!userSongRepository.existsById(id)) {
            throw new NotFoundException(String.format("Песни с таким id = %d не существует", id));
        }
    }
}
