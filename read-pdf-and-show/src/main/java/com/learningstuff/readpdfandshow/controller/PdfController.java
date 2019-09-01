package com.learningstuff.readpdfandshow.controller;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

@RestController
public class PdfController {

    @GetMapping(value = "file")
    public ResponseEntity<?> showPdf() {

        File file = new File("job.pdf");
        if (file.exists()) try {
            InputStream inputStream = new FileInputStream(file);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

    @GetMapping(value = "file-1")
    public ResponseEntity<?> showPdf1() {

        File file = new File("job.pdf");
        if (file.exists()) try {
            InputStream inputStream = new FileInputStream(file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

    @GetMapping(value = "download")
    public ResponseEntity<?> downloadPdf1() {

        File file = new File("job.pdf");
        if (file.exists()) try {
            InputStream inputStream = new FileInputStream(file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + UUID.randomUUID() + ".pdf");

            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

    @GetMapping(value = "url-file")
    public ResponseEntity<?> urlShowPdf() {

        try {
            URL url = new URL("http://www.orimi.com/pdf-test.pdf");
            InputStream inputStream = url.openStream();


            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(inputStream));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

    @GetMapping(value = "url-file-1")
    public ResponseEntity<?> showURLPdf1() {

        try {
            URL url = new URL("http://www.orimi.com/pdf-test.pdf");
            InputStream inputStream = url.openStream();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

    @GetMapping(value = "url-download")
    public ResponseEntity<?> urlDownloadPdf1() {

       try {
           URL url = new URL("http://www.orimi.com/pdf-test.pdf");
           InputStream inputStream = url.openStream();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + UUID.randomUUID() + ".pdf");

            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("No content!");
    }

}
