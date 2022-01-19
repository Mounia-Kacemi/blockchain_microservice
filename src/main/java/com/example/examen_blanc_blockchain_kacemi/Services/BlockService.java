package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;

import java.util.List;

public interface BlockService {
    public String calculateBlockHash(Block block);

    public void mineBlock(int difficulty, Block block);
    public Block createBlock(List<Transaction> transactions);

}
