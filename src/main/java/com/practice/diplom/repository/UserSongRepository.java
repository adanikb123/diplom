package com.practice.diplom.repository;

import com.practice.diplom.entity.UserSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSongRepository extends JpaRepository<UserSong,Long> {
    Page<UserSong> findAllByUserId(Long id, Pageable pageable);
}
