package com.example.examen_blanc_blockchain_kacemi.Services;


import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainResponse;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockRequest;
import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;

public interface BlockchainService {
    BlockChainResponse Add(BlockChainRequest blockChainRequest);
    void miner(String BlockChainId, BlockRequest blockRequest) throws Exception;
    Block getDernBlock(String BlockChainId);
    boolean isValid(Blockchain blockChain);
    double solde(String address);
}