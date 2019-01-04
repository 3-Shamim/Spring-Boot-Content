package com.learningstuff.springsecuritymothod.controller;

import com.learningstuff.springsecuritymothod.model.Book;
import com.learningstuff.springsecuritymothod.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
//    @Secured("ADMIN")
//    @RolesAllowed("ADMIN")
    @RolesAllowed({"ADMIN", "USER"})
//    @PreAuthorize("hasAnyRole('ADMIN')") // Before  method invoke
//    @PostAuthorize("hasAnyRole('ADMIN')") // After method invoke
    @PostFilter("filterObject.user.name == principal.username") // after execution
//    @PostFilter("filterObject.user.name == principal.username") // before execution
//    @PostAuthorize("hasAnyRole('ADMIN')") // After method invoke
    public List<Book> getAdminBook() {
        return bookService.getBookList();
    }

    @GetMapping(value = "/book/{id}")
    @PostAuthorize("principal.username == #model[book].user.name")
    public Book getBook(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return book;
    }

}
