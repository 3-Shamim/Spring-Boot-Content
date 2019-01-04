package com.learningstuff.onetomany;

import com.learningstuff.onetomany.model.Address;
import com.learningstuff.onetomany.model.Book;
import com.learningstuff.onetomany.model.User;
import com.learningstuff.onetomany.repo.AddressRepo;
import com.learningstuff.onetomany.repo.BookRepo;
import com.learningstuff.onetomany.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class OneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToManyApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(UserRepo userRepo, BookRepo bookRepo, AddressRepo addressRepo) {
        return args -> {

            User user = new User(1, "Name");
            userRepo.save(user);

            Book book = new Book(1, "Book1");
            Book book1 = new Book(2, "Book2");

            book.setUser(user);
            book1.setUser(user);

            bookRepo.saveAll(Arrays.asList(book, book1)).forEach(System.out::println);

            bookRepo.deleteById(1);

            Address address = new Address(1, "Address1");
            Address address1 = new Address(2, "Address2");

            address.setUser(user);
            address1.setUser(user);

            addressRepo.saveAll(Arrays.asList(address, address1)).forEach(System.out::println);

            addressRepo.deleteById(2);


            System.out.println(userRepo.findAll());


        };
    }

}
