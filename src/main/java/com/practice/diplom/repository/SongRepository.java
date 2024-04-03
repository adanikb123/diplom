package com.practice.diplom.repository;

import com.practice.diplom.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
    Page<Song> findAll(Pageable pageable);
    Page<Song> findAllByAuthor(String author, Pageable pageable);
}
