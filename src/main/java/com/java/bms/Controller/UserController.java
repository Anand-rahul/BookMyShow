package com.java.bms.Controller;

import com.java.bms.Model.User;
import com.java.bms.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<Page<User>> getAllUsersPaginated(
            @Parameter(description = "Page number")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Items per page")
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.fetchAllUsersPaginated(PageRequest.of(page, size)));
    }


    // Fetch a user by username
    @Operation(summary = "Get user by username")
    @GetMapping("/username/{userName}")
    public ResponseEntity<User> getUserByUsername(
            @PathVariable @NotBlank String userName) {
        return ResponseEntity.ok(userService.fetchByUserName(userName));
    }

    // Fetch a user by ID
    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable @Positive int id) throws Exception {
        return ResponseEntity.ok(userService.fetchUserById(id)
                .orElseThrow(() -> new Exception("User not found with id: " + id)));
    }

    // Create a new user
    @Operation(summary = "Create new user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createNewUser(user));
    }

    // Update an existing user
    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable @Positive int id,
            @Valid @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    // Delete a user by ID
    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @Positive int id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
