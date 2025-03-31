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
import com.example.demo.entities.FinancialGoal;
import com.example.demo.services.FinancialGoalService;

@RestController
public class FinanceGoalController {
    @Autowired
    private FinancialGoalService fr;
     @PostMapping("/finance/add")
    public FinancialGoal insertFinancialGoal(@RequestBody FinancialGoal f)
    {
        return fr.insertfinance(f);
    }
    @GetMapping("/finance/get")
    public List<FinancialGoal> getFinancialGoal()
    {
        return fr.getfinance();
    }
    @GetMapping("/finance/get/{id}")
        public ResponseEntity<FinancialGoal>getFinancebyId(@PathVariable int id)
    {
        Optional<FinancialGoal>t=fr.getfinancebyid(id);
        if(t.isPresent())
        {
            return ResponseEntity.ok(t.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/finance/update/{id}")
    public FinancialGoal updateFinancialGoal(@PathVariable int id,@RequestBody FinancialGoal f)
    {
        return fr.updatefinance(id,f);
    }
    @DeleteMapping("/finance/delete/{id}")
    public String deleteFinancialGoal(@PathVariable int id)
    {
        return fr.deletefinancebyid(id);
    }



    
}
