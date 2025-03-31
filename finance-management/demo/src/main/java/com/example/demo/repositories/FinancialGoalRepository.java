package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FinancialGoal;

public interface FinancialGoalRepository extends JpaRepository<FinancialGoal,Integer>{
    
}
