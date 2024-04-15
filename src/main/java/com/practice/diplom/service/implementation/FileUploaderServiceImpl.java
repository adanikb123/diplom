package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.FileDto;
import com.practice.diplom.entity.UploadedFile;
import com.practice.diplom.repository.FileUploaderRepository;
import com.practice.diplom.service.FileUploaderService;
import com.practice.diplom.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

@Service
public class FileUploaderServiceImpl implements FileUploaderService {
    @Autowired
    private StorageService storageService;

    @Autowired
    private FileUploaderRepository fileUploaderRepository;

    @Override
    public FileDto uploadFile(MultipartFile file) {
        File savedFile = storageService.saveFile(file);

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setName(savedFile.getName());
        uploadedFile.setUrl(fixUrl(savedFile.getPath()));
        uploadedFile.setDate(LocalDateTime.now());
        fileUploaderRepository.save(uploadedFile);

        FileDto response =  new FileDto();
        response.setId(uploadedFile.getId());
        response.setName(uploadedFile.getName());
        response.setUrl(uploadedFile.getUrl());
        return response;
    }

    @Override
    public void deleteFile(FileDto fileDto) {

        storageService.deleteFile(fileDto);
        fileUploaderRepository.deleteById(fileDto.getId());

    }

    private String fixUrl(String url){
        System.out.println(url);
        return  url.substring(url.indexOf("\\storage")).replace("\\","/");
    }
}
