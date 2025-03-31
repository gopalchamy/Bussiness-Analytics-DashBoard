package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.FinancialGoal;
import com.example.demo.repositories.FinancialGoalRepository;

@Service
public class FinancialGoalService {
    @Autowired
    private FinancialGoalRepository fr;
    public FinancialGoal insertfinance(FinancialGoal f)
    {
        return fr.save(f);
    }
    public List<FinancialGoal>getfinance()
    {
        return fr.findAll();
    }
    public Optional<FinancialGoal>getfinancebyid(int id)
    {
        return fr.findById(id);
    }
    public FinancialGoal updatefinance(int id,FinancialGoal f)
    {
        f.setId(id);
        return fr.save(f);

    }
    public String deletefinancebyid(int id)
    {
        fr.deleteById(id);
        return "FinanceGoal is deleted";
    }

    
}
