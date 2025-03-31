package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Budget;
import com.example.demo.repositories.BudgetRepository;
import org.springframework.stereotype.Service;


@Service
public class BudgetService {
    @Autowired
    private BudgetRepository b;
    public Budget addbudget(Budget bu)
    {
        return b.save(bu);
    }
    public List<Budget> getbudget()
    {
        return b.findAll();
    }
    public Optional<Budget>getbudgetbyid(int id)
    {
        return b.findById(id);
    }
    public Budget getbycat(int id,String cat)
    {
        Optional<Budget>bud=b.findByIdAndCategory(id,cat);
        return bud.orElse(null);
    }
    public Budget updatebyid(int id,Budget bud)
    {
        bud.setId(id);
        return b.save(bud);
    }
    public String deletebyid(int id)
    {
        b.deleteById(id);
        String m;
        m="Budget with ID "+id+" has been deleted successfully";
        return m;
    }

       
    
    
}
