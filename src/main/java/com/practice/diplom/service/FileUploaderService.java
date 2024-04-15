package com.practice.diplom.service;

import com.practice.diplom.dto.FileDto;
import com.practice.diplom.entity.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploaderService {
    FileDto uploadFile(MultipartFile file);

    void deleteFile(FileDto fileDto);
}
