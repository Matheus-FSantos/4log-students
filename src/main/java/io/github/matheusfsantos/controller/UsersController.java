package io.github.matheusfsantos.controller;

import io.github.matheusfsantos.model.domain.Users;
import io.github.matheusfsantos.model.dto.UsersDTO;
import io.github.matheusfsantos.model.exception.AppErrors;
import io.github.matheusfsantos.model.feign.ViaCepService;
import io.github.matheusfsantos.model.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<UsersDTO>> findAll() throws AppErrors {
        return ResponseEntity.status(HttpStatus.OK).body(this.usersService.findAll());
    }

    @GetMapping("/users/{ra}")
    public ResponseEntity<UsersDTO> findById(@PathVariable String ra) throws AppErrors {
        return ResponseEntity.status(HttpStatus.OK).body(this.usersService.findById(ra));
    }

    @PostMapping("/users")
    public ResponseEntity<Void> save(@RequestBody Users user) throws AppErrors {
        this.usersService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/users/{ra}")
    public ResponseEntity<Void> update(@RequestBody Users updatedUser, @PathVariable String ra) throws AppErrors {
        this.usersService.update(updatedUser, ra);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws AppErrors {
        this.usersService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
