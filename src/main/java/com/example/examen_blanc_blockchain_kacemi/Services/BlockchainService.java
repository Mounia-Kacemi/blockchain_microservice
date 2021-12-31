package com.example.examen_blanc_blockchain_kacemi.Services;


import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;

public interface BlockchainService {

    public void addBlock(Block addedBlock);

    public void generateGenesisBlock();

    Boolean isBlockChainValid(Blockchain blockchain);
}