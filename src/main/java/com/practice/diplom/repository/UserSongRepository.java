package com.practice.diplom.repository;

import com.practice.diplom.entity.UserSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSongRepository extends JpaRepository<UserSong,Long> {
    List<UserSong> findAllByUserId(Long id);
}
