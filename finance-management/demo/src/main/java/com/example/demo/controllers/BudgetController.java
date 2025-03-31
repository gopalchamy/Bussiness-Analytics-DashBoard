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

import com.example.demo.entities.Budget;

import com.example.demo.services.BudgetService;
@RestController
public class BudgetController {
    @Autowired
    private BudgetService b;
    @PostMapping("/budget/add")
    public Budget insertbudget(@RequestBody Budget bu)
    {
        return b.addbudget(bu);
    }
    @GetMapping("/budget/get")
    public List<Budget> getBuget()
    {
        return b.getbudget();
    }
    @GetMapping("/budget/get/{id}")
     public ResponseEntity<Budget>getBudgetbyid(@PathVariable int id)
    {
        Optional<Budget>bu=b.getbudgetbyid(id);
        if(bu.isPresent())
        {
            return ResponseEntity.ok(bu.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/budget/get/{id}/{category}")
    public Budget getBudgetbycateory(@PathVariable int id,@PathVariable String category)
    {
       return b.getbycat(id,category);
        
    }
    @PutMapping("/budget/update/{id}")
    public Budget updatebudget(@PathVariable int id,@RequestBody Budget bu)
    {
        return b.updatebyid(id,bu);
    }
    @DeleteMapping("/budget/delete/{id}")
    public String deletebudget(@PathVariable int id)
    {
        return b.deletebyid(id);
    }


    
}
