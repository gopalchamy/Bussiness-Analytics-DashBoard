package com.example.demo.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.example.demo.services.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService tr;
    @PostMapping("/transaction/add/{userid}/{catid}")
    public Transaction insertTransaction(@PathVariable int userid,@PathVariable int catid,@RequestBody Transaction t)
    {
        
        return tr.inserttransaction(userid,catid,t);
    }
     @PutMapping("/transaction/update/{id}")
    public Transaction updateTransaction(@PathVariable int id,@RequestBody Transaction t)
    {
        return tr.updatetransaction(id,t);
    }
    @DeleteMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable int id)
    {
        return tr.deletetransactionbyid(id);
    }
 

    @GetMapping("/transaction/paging")
    public Page<Transaction>getPageLanguage(@RequestParam int page,@RequestParam int size,@RequestParam String sortBy,@RequestParam String direction)
    {
        return tr.getTransactionPage(page,size,sortBy,direction);
    }
    @GetMapping("/transaction/getByAmount/{amount}")
public List<Transaction> getTransactionsByAmount(@PathVariable double amount) {
    return tr.getTransactionsByAmount(amount);
}

    
}
