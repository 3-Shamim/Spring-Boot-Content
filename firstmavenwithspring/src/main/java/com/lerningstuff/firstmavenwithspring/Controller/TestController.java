package com.lerningstuff.firstmavenwithspring.Controller;

import com.lerningstuff.firstmavenwithspring.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/List")
public class TestController {
    private List<Student> studentList = new ArrayList<>();
    private static String UPLOADED_FOLDER = "J://";

    @RequestMapping(value = "")
    public String sayHello(Model model)
    {
        Collections.sort(studentList,(s1, s2) -> s1.getId() - s2.getId());
//        studentList = studentList.stream().sorted(Comparator.comparing(Student :: getId)).collect(Collectors.toList());
        model.addAttribute("title","Hello List");
        model.addAttribute("studentList",studentList);
        return "Test/Index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model)
    {
        model.addAttribute("student",new Student());
        model.addAttribute("title","Add Student");
        return "Test/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Valid Student student, Errors errors)
    {
        if(errors.hasErrors())
        {
            return "Test/form";
        }
        studentList.add(student);
        return "redirect:";
    }
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model)
    {
        model.addAttribute("title","Upload Image");
        return "Test/upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String processUpload(@RequestParam(name = "file") MultipartFile file, Model model)
    {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "redirect:/List/uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            /*byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            model.addAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");*/

            byte[] design = file.getBytes();

            System.out.println(design.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/List/uploadStatus";
    }
    @RequestMapping(value = "/uploadStatus", method = RequestMethod.GET)
    public String uploadStatus(Model model)
    {
        model.addAttribute("title","UploadStatus Image");
        return "Test/uploadStatus";
    }
}
