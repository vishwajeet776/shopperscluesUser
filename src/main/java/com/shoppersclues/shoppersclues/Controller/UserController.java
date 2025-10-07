package com.shoppersclues.shoppersclues.Controller;

import com.shoppersclues.shoppersclues.Entity.User;
import com.shoppersclues.shoppersclues.Service.UserService;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
       return  userService.add_user(user);
    }
    
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id){
        return userService.get_byId(id);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
         userService.delete_byId(id);
    }

    @PatchMapping("/{id}")
    public User updateById(@PathVariable long id,@RequestBody Map<String, Object> updates ){
        return userService.update_ById(id,updates);
    }


}
