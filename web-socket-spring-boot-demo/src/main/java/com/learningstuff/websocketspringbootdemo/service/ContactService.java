package com.learningstuff.websocketspringbootdemo.service;

import com.learningstuff.websocketspringbootdemo.model.Contact;
import com.learningstuff.websocketspringbootdemo.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {

    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }
    public List<Contact> findAllContactOrderByTimeDesc() {
        return contactRepository.findAllByOrderByTimeDesc();
    }

    public Optional<Contact> findContactById(long id) {

        return contactRepository.findById(id);
    }

    public void deleteContactById(long id) {
        Optional<Contact> optionalContact = findContactById(id);
        optionalContact.ifPresent(contactRepository::delete);
    }

    public long countUnseenContact() {
        return contactRepository.countContactBySeenFalse();
    }

    public List<Contact> findUnseenContact() {
        return contactRepository.findContactBySeenFalse();
    }

}
