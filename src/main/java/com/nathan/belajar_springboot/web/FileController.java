package com.nathan.belajar_springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nathan.belajar_springboot.dto.PresignedUrlResponseDto;
import com.nathan.belajar_springboot.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/link/{fileName}")
    public ResponseEntity<PresignedUrlResponseDto> generateUploadLink(
            @PathVariable String fileName) {
        PresignedUrlResponseDto dto = fileService.generateUploadLink(fileName);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            fileService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
