package com.learningstuff.springsecuritymothod.service;

import com.learningstuff.springsecuritymothod.model.Book;
import com.learningstuff.springsecuritymothod.model.Role;
import com.learningstuff.springsecuritymothod.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "Book1", new User(1, "admin", Role.ADMIN)));
        bookList.add(new Book(2, "Book2", new User(2, "user", Role.USER)));
        bookList.add(new Book(3, "Book3", new User(3, "shamim", Role.USER)));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Book findBookById(int id) {
        return bookList.stream().filter(new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                if (book.getId() == id)
                    return true;
                return false;
            }
        }).findFirst().orElse(new Book(0, "No Book", null));
    }
}
