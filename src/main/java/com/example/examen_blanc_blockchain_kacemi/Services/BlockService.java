package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;

import java.util.List;

public interface BlockService {
    String calculateBlockHash(Block block);

    public String mineBlock(int difficulty, Block block);
    public boolean addTransaction(Transaction transaction);

    List<Block> findAll();
}
