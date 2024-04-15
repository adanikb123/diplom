package com.practice.diplom.service;

import com.practice.diplom.dto.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface StorageService {

    File saveFile(MultipartFile file);

    void deleteFile(FileDto fileDto);
}
