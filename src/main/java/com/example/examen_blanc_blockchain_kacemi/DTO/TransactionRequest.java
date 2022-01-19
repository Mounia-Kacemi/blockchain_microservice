package com.example.examen_blanc_blockchain_kacemi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private String adressSource ;
    private String adressDest;
    private double montant;
}
