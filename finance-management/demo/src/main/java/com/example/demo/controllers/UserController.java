package com.example.demo.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {
    @Autowired
    UserService s;
    @PostMapping("/user/add")
    public User insertuser(@RequestBody User us)
    {
        return s.adduser(us);
    }
    @GetMapping("/user/get")
    public List<User> getalluser()
    {
        return s.getuser();
    }
    @GetMapping("/user/get/{email}")
    public ResponseEntity<User>getuser(@PathVariable String email)
    {
        Optional<User>u=s.getuserbyemail(email);
        if(u.isPresent())
        {
            return ResponseEntity.ok(u.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/user/update/{id}")
    public User updateuserdetail(@PathVariable int id,@RequestBody User u)
    {
        return s.updateuser(id,u);
    }
    @DeleteMapping("/user/delete/{id}")
    public String deleteuserbyid(@PathVariable int id)
    {
        return s.deleteuser(id);
    }
    
    @GetMapping("/user/gettransactionbyid/{id}")
    public List<Transaction>getTransactionByUserId(@PathVariable int id)
    {
        return s.getTransactionByUserId(id);
    }


}
