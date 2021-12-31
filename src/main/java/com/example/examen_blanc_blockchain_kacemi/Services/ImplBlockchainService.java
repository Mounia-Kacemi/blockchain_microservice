package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockChainRepository;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockRepository;
import com.example.examen_blanc_blockchain_kacemi.Repositories.TransactionRepository;
import com.example.examen_blanc_blockchain_kacemi.mappers.BlockChainMapper;

import java.util.List;


public class ImplBlockchainService implements BlockchainService {
    private BlockChainRepository blockChainRepository;
    private BlockChainMapper blockChainMapper;
    private BlockService blockService;
    private BlockRepository blockRepository;
    private TransactionRepository transactionRepository;

    public ImplBlockchainService(BlockChainRepository blockChainRepository, BlockChainMapper blockChainMapper, BlockService blockService, BlockRepository blockRepository, TransactionRepository transactionRepository) {
        this.blockChainRepository = blockChainRepository;
        this.blockChainMapper = blockChainMapper;
        this.blockService = blockService;
        this.blockRepository = blockRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void addBlock(Block addedBlock) {

    }

    @Override
    public void generateGenesisBlock() {

    }

    @Override
    public Boolean isBlockChainValid(Blockchain blockchain) {
        List<Block> list = blockchain.getBlocks();

        for(int i=1;i<list.size();i++){

            if(!list.get(i).getHash().equals(blockService.calculateBlockHash(list.get(i))) || !list.get(i).getHash().equals(list.get(i-1)))
                return false;
        }
        return true;
    }
}

