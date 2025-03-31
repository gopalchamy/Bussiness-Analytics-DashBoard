package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Budget;
@Repository
public interface BudgetRepository  extends JpaRepository<Budget,Integer>
{
    Optional<Budget>findByIdAndCategory(int id,String category);
}
