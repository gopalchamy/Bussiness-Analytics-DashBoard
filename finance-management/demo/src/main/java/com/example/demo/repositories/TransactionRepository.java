package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Page<Transaction> findAll(Pageable pageable);

    @Query("SELECT t FROM Transaction t WHERE t.amount >= :amount")
    List<Transaction> findByAmount(@Param("amount") double amount);
    List<Transaction> findByUserId(int userId);
    

    
}
