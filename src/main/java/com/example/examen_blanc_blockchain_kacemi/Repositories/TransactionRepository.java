package com.example.examen_blanc_blockchain_kacemi.Repositories;

import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<Transaction,String> {
    List<Transaction> findByadressDest(String address);

}