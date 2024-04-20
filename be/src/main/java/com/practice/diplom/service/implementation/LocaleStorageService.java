package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.FileDto;
import com.practice.diplom.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LocaleStorageService implements StorageService {
    private static final String PATH_TO_STORAGE = "/app/storage/";
    @Override
    public File saveFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        File dest = new File(PATH_TO_STORAGE + fileName );
        try {
            multipartFile.transferTo(dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return dest;
    }

    @Override
    public void deleteFile(FileDto fileDto) {

        try {
            Files.deleteIfExists(Paths.get(PATH_TO_STORAGE + fileDto.getName()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
