package com.learnigstuff.imagewithspringbootusingpath.controller;

import com.learnigstuff.imagewithspringbootusingpath.model.Image;
import com.learnigstuff.imagewithspringbootusingpath.service.ImageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "image")
public class ViewController {

    private static final String BASE_PATH = "/images";
    private static final String FILE_NAME = "{filename:.+}";

    private final ImageService imageService;

    public ViewController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "")
    public String index(Model model) {
        List<Image> images = imageService.findPage();
        model.addAttribute("images", images);

        images.forEach(System.out::println);

        return "index";
    }

    @GetMapping(value = BASE_PATH + "/" + FILE_NAME)
    @ResponseBody
    public ResponseEntity<?> serveFile(@PathVariable String filename) {

        try {
            Resource oneImage = imageService.findOneImage(filename);
            return ResponseEntity.ok().contentLength(oneImage.contentLength()).contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(oneImage.getInputStream()));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body("couldn't find image");
        }


    }

    @PostMapping(value = "add")
    public String createFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            imageService.saveImage(file);
            redirectAttributes.addAttribute("flash.message",
                    "Successfully upload " + file.getOriginalFilename());
        } catch (IOException e) {
            redirectAttributes.addAttribute("flash.message",
                    "Failed to upload " + file.getOriginalFilename());
        }

        return "redirect:/image";
    }

}
