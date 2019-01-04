package com.learnigstuff.imagewithspringbootusingpath.service;

import com.learnigstuff.imagewithspringbootusingpath.model.Image;
import com.learnigstuff.imagewithspringbootusingpath.repository.ImageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageService {

    private static final String UPLOAD_ROOT =  "upload-dir";

    private final ImageRepository imageRepository;
    private final ResourceLoader resourceLoader;

    public ImageService(ImageRepository imageRepository, ResourceLoader resourceLoader) {
        this.imageRepository = imageRepository;
        this.resourceLoader = resourceLoader;
    }

    public void saveImage(MultipartFile file) throws IOException {

        if(!file.isEmpty()) {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_ROOT, file.getOriginalFilename()));
            imageRepository.save(new Image(file.getOriginalFilename()));
        }

    }

    public Resource findOneImage(String fileName) {
        return resourceLoader.getResource("file:" + UPLOAD_ROOT + "/" + fileName);
    }

    public List<Image> findPage() {
        return imageRepository.findAll();
    }

    public void deleteImage(String fileName) throws IOException {
        final Image byName = imageRepository.findImageByName(fileName);
        imageRepository.delete(byName);
        Files.deleteIfExists(Paths.get(UPLOAD_ROOT, fileName));
    }

    @Bean
    CommandLineRunner setUp(ImageRepository imageRepository) {
        return args -> {

            FileSystemUtils.deleteRecursively(new File(UPLOAD_ROOT));
            Files.createDirectory(Paths.get(UPLOAD_ROOT));
            FileCopyUtils.copy("Test file", new FileWriter(UPLOAD_ROOT + "/test1"));
            imageRepository.save(new Image("test1"));
            FileCopyUtils.copy("Test file", new FileWriter(UPLOAD_ROOT + "/test2"));
            imageRepository.save(new Image("test2"));
            FileCopyUtils.copy("Test file", new FileWriter(UPLOAD_ROOT + "/test3"));
            imageRepository.save(new Image("test3"));
        };
    }

}
