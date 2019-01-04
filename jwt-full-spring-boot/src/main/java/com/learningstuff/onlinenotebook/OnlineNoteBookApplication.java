package com.learningstuff.onlinenotebook;

import com.learningstuff.onlinenotebook.model.Note;
import com.learningstuff.onlinenotebook.model.Role;
import com.learningstuff.onlinenotebook.model.User;
import com.learningstuff.onlinenotebook.sevice.NoteService;
import com.learningstuff.onlinenotebook.sevice.RoleService;
import com.learningstuff.onlinenotebook.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineNoteBookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OnlineNoteBookApplication.class, args);
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private NoteService noteService;

    @Override
    public void run(String... args) throws Exception {

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User("user@mail.com", "User", new BCryptPasswordEncoder().encode("123456"), "Address", null, roles);
        userService.createUser(user);

        noteService.saveNote(new Note("Note 1", "Note 1"), user);
        noteService.saveNote(new Note("Note 2", "Note 2"), user);
        noteService.saveNote(new Note("Note 3", "Note 3"), user);
        roles.clear();

        roles.add(roleService.findByRole("USER"));
        roles.add(new Role("ADMIN"));
        User admin = new User("admin@mail.com", "Admin", new BCryptPasswordEncoder().encode("123456"), "Address", null, roles);
        userService.createUser(admin);

        noteService.saveNote(new Note("Note 1", "Note 1"), admin);
        noteService.saveNote(new Note("Note 2", "Note 2"), admin);
        noteService.saveNote(new Note("Note 3", "Note 3"), admin);

    }
}
