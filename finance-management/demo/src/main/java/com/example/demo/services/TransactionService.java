package com.example.demo.services;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entities.Category;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.TransactionRepository;
import com.example.demo.repositories.UserRepository;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository tr;
     
    @Autowired
    private UserRepository repo;
    @Autowired
    private CategoryRepository cs;

     
 
    public Transaction inserttransaction(int userid,int catid,Transaction t)
    {
        if (t == null) {
            throw new IllegalArgumentException("Transaction object cannot be null");
        }
        if (catid <= 0) {
            throw new IllegalArgumentException("Invalid Category ID: " + catid);
        }
        
        User user = repo.findById(userid)
            .orElseThrow(() -> new RuntimeException("User not found"));
        t.setUser(user);
        Category cat=cs.findById(catid).orElseThrow(() -> new RuntimeException("Categoryid not found"));
        t.setCategory(cat);
        
        

        
        return tr.save(t);
    }
    
    public List<Transaction>gettransaction()
    {
        return tr.findAll();
    }
    public List<Transaction>gettransactionbyid(int id)
    {
        return tr.findByUserId(id);
    }
    public Transaction updatetransaction(int id,Transaction t)
    {
        t.setId(id);
        return tr.save(t);

    }
    public String deletetransactionbyid(int id)
    {
        tr.deleteById(id);
        return "Transaction is deleted";
    }
    public List<Transaction> getTransactionsByAmount(double amount) {
        return tr.findByAmount(amount);
    }
    public List<Transaction> getTransactionbyuserid(int uid) {
        User u=repo.findById(uid).orElseThrow(() -> new RuntimeException("User not found"));
        return u.getTransactions();
    }
    public List<Transaction> getTransactionbycatid(int uid) {
        Category u=cs.findById(uid).orElseThrow(() -> new RuntimeException("User not found"));
        return u.getTransactions();
    }
     public Page<Transaction> getTransactionPage(int page,int size,String sortBy,String direction){
        Sort sort=direction.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable=PageRequest.of(page,size,sort);
        return tr.findAll(pageable);
    }
    
}

    

