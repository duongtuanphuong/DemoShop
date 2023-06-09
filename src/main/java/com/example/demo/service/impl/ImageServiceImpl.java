package com.example.demo.service.impl;

import com.example.demo.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl  implements ImageService {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads";

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        File uploadDirectory = new File(UPLOAD_DIRECTORY);
       if (!uploadDirectory.exists()) {
           uploadDirectory.mkdirs();
       }
        String uid = UUID.randomUUID().toString();

        String originalFilename = file.getOriginalFilename();
        // String newFilename = uid + "_" + originalFilename;

        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, originalFilename);
        Files.write(fileNameAndPath, file.getBytes());

        return originalFilename;
    }

    @Override
    public void deleteImage(String imagePath) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIRECTORY,imagePath);
        Files.delete(filePath);
    }
}
