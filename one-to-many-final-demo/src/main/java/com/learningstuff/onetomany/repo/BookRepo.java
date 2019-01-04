package com.learningstuff.onetomany.repo;

import com.learningstuff.onetomany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepo extends JpaRepository<Book, Integer> {
}
