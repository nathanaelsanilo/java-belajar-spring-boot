package com.nathan.belajar_springboot.service;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nathan.belajar_springboot.dto.PresignedUrlResponseDto;

import io.minio.BucketExistsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import jakarta.mail.Multipart;

@Service
public class FileService {

    @Value("${minio.bucket}")
    private String bucketName;

    @Autowired
    private MinioClient minioClient;

    public void uploadFile(MultipartFile file) throws Exception {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(file.getOriginalFilename())
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());
    }

    public PresignedUrlResponseDto generateUploadLink(String fileName) {
        String url;
        try {
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .expiry(10, TimeUnit.MINUTES)
                            .method(Method.PUT)
                            .build());
            return new PresignedUrlResponseDto(url);
        } catch (Exception e) {
            e.printStackTrace();
            return new PresignedUrlResponseDto(null);
        }
    }
}
