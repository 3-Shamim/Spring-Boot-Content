package com.learningstuff.onlinenotebook.controller;


import com.learningstuff.onlinenotebook.model.Note;
import com.learningstuff.onlinenotebook.model.User;
import com.learningstuff.onlinenotebook.sevice.NoteService;
import com.learningstuff.onlinenotebook.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping(value = "api")
public class ApiController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "save-note")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> saveNote(@RequestBody Note note, Principal principal) {

        User user = userService.findUserByEmail(principal.getName()).get();

        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.saveNote(note, user));
    }

    @GetMapping(value = "notes")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> getNoteBooks(Principal principal) {

        User user = userService.findUserByEmail(principal.getName()).get();

        return ResponseEntity.status(HttpStatus.OK).body(noteService.findAllNotesByUser(user));
    }

    @GetMapping(value = "note/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> getNoteBook(@PathVariable long id, Principal principal) {

        User user = userService.findUserByEmail(principal.getName()).get();
        Note note = noteService.findNoteById(id, user);

        if (note != null) {
            return ResponseEntity.status(HttpStatus.OK).body(note);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Note not found!");
        }

    }

    @DeleteMapping(value = "delete-note/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> deleteNoteBook(@PathVariable long id, Principal principal) {
        User user = userService.findUserByEmail(principal.getName()).get();
        int isDeleted = noteService.deleteNoteById(id, user);
        if (isDeleted > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }


    @GetMapping(value = "users")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.status(HttpStatus.OK).body("OK - Users");
    }

}
