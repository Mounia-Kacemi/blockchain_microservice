package com.example.examen_blanc_blockchain_kacemi.DTO;

import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockResponse {
    private String hash;
    private String previousHash;
    private Date date_creat;
    private int nonce;
    private List<Transaction> transactions;
}
