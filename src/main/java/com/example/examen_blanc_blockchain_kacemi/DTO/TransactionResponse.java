package com.example.examen_blanc_blockchain_kacemi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Date date_trans;
    private String adressSource ;
    private String adressDest;
    private double montant;
}
