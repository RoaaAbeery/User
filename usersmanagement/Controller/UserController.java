package com.example.usersmanagement.Controller;

import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getusers());
    }
    @PostMapping("/addUsers")
     public ResponseEntity addUsers(@RequestBody@Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addUsers(user);
        return ResponseEntity.status(HttpStatus.OK).body("User add");
     }
     @PutMapping("/updateUsers/{id}")
     public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody@Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.updateUsers(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("user updated");
     }
     @DeleteMapping("/deleteUser/{id}")
     public ResponseEntity delteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
     }
     @GetMapping("/getEmail/{email}")
    public ResponseEntity getEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getEmail(email));
     }
    @GetMapping("/getRole/{role}")
    public ResponseEntity getRole(@PathVariable String role){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getRole(role));
    }
    @GetMapping("/getAge/{age}")
    public ResponseEntity getAge(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAgr(age));
    }
    @GetMapping("/CheckUser/{username}/{paassword}")
    public ResponseEntity check(@PathVariable String username,@PathVariable String paassword){
        return ResponseEntity.status(HttpStatus.OK).body(userService.check(username, paassword));
    }
}
