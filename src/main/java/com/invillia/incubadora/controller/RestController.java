package com.invillia.incubadora.controller;

import java.util.Optional;

import com.invillia.incubadora.model.User;
import com.invillia.incubadora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author s2it_pandrade
 * @version : $<br/>
 * : $
 * @since 25/10/19 14:37
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/user")
public class RestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        final Optional<User> byId = userRepository.findById(id);
        return byId.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        final User userSaved = userRepository.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        final User userSaved = userRepository.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<User> delete(@RequestBody User user) {
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
