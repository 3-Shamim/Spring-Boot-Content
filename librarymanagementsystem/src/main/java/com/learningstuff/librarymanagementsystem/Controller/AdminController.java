package com.learningstuff.librarymanagementsystem.Controller;

import com.learningstuff.librarymanagementsystem.Dao.BookDao;
import com.learningstuff.librarymanagementsystem.Dao.StudentDao;
import com.learningstuff.librarymanagementsystem.Model.Book;
import com.learningstuff.librarymanagementsystem.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/Home")
public class AdminController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "")
    public String index(Model model)
    {
        model.addAttribute("bookList", bookDao.findAll());
        model.addAttribute("title","Home");
        return "Home/Index";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model)
    {
        model.addAttribute("book",new Book());
        model.addAttribute("title","Add Book");
        return "Home/AddBook";
    }
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String processAddBook(@ModelAttribute @Valid Book book, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "Home/AddBook";
        }

        if(book.getQuantity() > 0)
        {
            book.setAvailability(true);
        }
        else
        {
            book.setAvailability(false);
        }

        bookDao.save(book);

        return "redirect:";
    }

    // Student Sector

    @RequestMapping(value = "/StudentList")
    public String StudentList(Model model)
    {
        model.addAttribute("studentList", studentDao.findAll());
        model.addAttribute("title","Student List");
        return "Home/StudentList";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model)
    {
        model.addAttribute("student",new Student());
        model.addAttribute("title","Add Student");
        return "Home/AddStudent";
    }
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String processAddStudent(@ModelAttribute @Valid Student student, Errors errors,@RequestParam(name = "sex") String sex)
    {
        if (errors.hasErrors())
        {
            return "Home/AddStudent";
        }
        student.setSex(sex);
        studentDao.save(student);

        return "redirect:/Home/StudentList";
    }
}
