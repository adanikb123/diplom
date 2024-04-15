package com.practice.diplom.controller;

import com.practice.diplom.dto.FileDto;
import com.practice.diplom.service.FileUploaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/file")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Файлы", description = "Методы для загрузки файлов")
public class FileController {
    @Autowired
    private FileUploaderService fileUploaderService;

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузка файла")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public FileDto uploadFile(@RequestPart("file") MultipartFile file)  {
        return fileUploaderService.uploadFile(file);
    }
    @DeleteMapping("/delete")
    @Operation(summary = "Удаление файла")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteFile(@RequestBody FileDto file) {
       fileUploaderService.deleteFile(file);
       return  HttpStatus.OK;
    }
}
