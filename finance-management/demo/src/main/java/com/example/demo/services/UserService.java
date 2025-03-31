package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public User adduser(User us)
    {
         if(us.getName().isEmpty() || us.getEmail().isEmpty() || us.getPassword().isEmpty())
        {
            throw new RuntimeException("All fields are required");
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(us.getEmail());

        if (!matcher.matches()) {
            throw new RuntimeException("Invalid email format.");
        }
        return repo.save(us);
    }
    public List<User>getuser()
    {
        return repo.findAll();
    }
    @Transactional
    public Optional<User>getuserbyemail(String email)
    {
        return repo.findByEmail(email);
    }
    public User updateuser(int id,User us)
    {
        us.setId(id);
        return repo.save(us);
    }
    public String deleteuser(int id)
    {
        repo.deleteById(id);
        return "Done";

    }
    public List<Transaction> getTransactionByUserId(int userid){
        User u=repo.findById(userid).orElseThrow(()->new RuntimeException("error"));
        return u.getTransactions();
    }    
}
