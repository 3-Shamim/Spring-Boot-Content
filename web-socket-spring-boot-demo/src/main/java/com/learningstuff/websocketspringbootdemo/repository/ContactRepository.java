package com.learningstuff.websocketspringbootdemo.repository;

import com.learningstuff.websocketspringbootdemo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactBySeenFalse();
    long countContactBySeenFalse();
    List<Contact> findAllByOrderByTimeDesc();

}
