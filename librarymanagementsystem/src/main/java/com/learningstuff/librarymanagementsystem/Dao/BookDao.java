package com.learningstuff.librarymanagementsystem.Dao;

import com.learningstuff.librarymanagementsystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookDao extends JpaRepository<Book, Integer> {
}
