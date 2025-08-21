package com.sunat.device.testing.controller;

import com.sunat.device.testing.entity.User;
import com.sunat.device.testing.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuarios", description = "Operaciones sobre usuarios")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Operation(summary = "Listar todos los usuarios")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}