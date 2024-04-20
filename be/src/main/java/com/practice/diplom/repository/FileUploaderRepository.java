package com.practice.diplom.repository;

import com.practice.diplom.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploaderRepository extends JpaRepository<UploadedFile,Long> {
}
