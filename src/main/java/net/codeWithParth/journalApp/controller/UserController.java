package net.codeWithParth.journalApp.controller;

import net.codeWithParth.journalApp.entity.JournalEntry;
import net.codeWithParth.journalApp.entity.Users;
import net.codeWithParth.journalApp.repository.UserRepository;
import net.codeWithParth.journalApp.service.JournalEntryService;
import net.codeWithParth.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public  List<Users> getAllUsers(){
        return userService.getALl();
    }
    @PostMapping
    public void createUser(@RequestBody Users user)
    {

        userService.saveEntry(user);
    }
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody Users user,@PathVariable String username)
    {
        Users userInDb = userService.findByUserName(username);
        if(userInDb != null)
        {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
