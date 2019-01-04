package com.learningstuff.springsessionwithredis.resource;

import com.learningstuff.springsessionwithredis.model.User;
import com.learningstuff.springsessionwithredis.session_dao.SessionDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserResource {

    private final SessionDataRepository sessionDataRepository;

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        sessionDataRepository.save(new User(id, name));
        return sessionDataRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        sessionDataRepository.update(new User(id, name));
        return sessionDataRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        sessionDataRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, User> all() {
        return sessionDataRepository.findAll();
    }


}
