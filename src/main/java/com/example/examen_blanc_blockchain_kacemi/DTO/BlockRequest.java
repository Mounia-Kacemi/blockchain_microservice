package com.example.examen_blanc_blockchain_kacemi.DTO;

import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockRequest {
    private String AdressMiner;
    private List<Transaction> transactions;
}
