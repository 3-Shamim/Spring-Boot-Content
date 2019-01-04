package com.learningstuff.imagedemoinspring.Controller;

import com.learningstuff.imagedemoinspring.Model.Image;
import com.learningstuff.imagedemoinspring.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private ImageRepository imageRepository;

    @RequestMapping(value = "")
    public String uploadImage(Model model)
    {
        model.addAttribute("title", "Upload Images !");
        model.addAttribute("fileList",imageRepository.findAll());
        return "uploads/upload";
    }
    @PostMapping(value = "/test")
    public String upload(@RequestParam MultipartFile file) {
        try {
            if(!file.isEmpty())
            {
                Image testUpload = new Image(file.getBytes());
                imageRepository.save(testUpload);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/image/{image_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") int imageId) throws IOException {

        byte[] imageContent = imageRepository.findOne(imageId).getFile();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/images/{image_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public String getImages(@PathVariable("image_id") int imageId, Model model) throws IOException {
        model.addAttribute("title", "Single Image");
        model.addAttribute("image",imageRepository.findOne(imageId));
        return "uploads/singleImage";
    }
}
