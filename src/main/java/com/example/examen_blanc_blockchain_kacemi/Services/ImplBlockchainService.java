package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainResponse;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockRequest;
import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockChainRepository;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockRepository;
import com.example.examen_blanc_blockchain_kacemi.Repositories.TransactionRepository;
import com.example.examen_blanc_blockchain_kacemi.mappers.BlockChainMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Data
public class ImplBlockchainService implements BlockchainService {
    private BlockChainRepository blockChainRepository;
    private BlockChainMapper blockChainMapper;
    private BlockService blockService;
    private BlockRepository blockRepository;
    private TransactionRepository transactionRepository;
    private List<Transaction> transactions;

    @Override
    public BlockChainResponse Add(BlockChainRequest blockChainRequest) {
        Blockchain blockChain=blockChainMapper.blockChainRequestToBlockChain(blockChainRequest);
        blockChain.setId(UUID.randomUUID().toString());
        Block genesisBlock= new Block(UUID.randomUUID().toString(),new Date(),null,new String(new char[blockChain.getDifficulte()]).replace('\0','0'),0,new ArrayList<>());
        blockService.mineBlock(blockChain.getDifficulte(),genesisBlock);
        blockRepository.save(genesisBlock);
        blockChain.setBlocks(new ArrayList<>());
        blockChain.getBlocks().add(genesisBlock);
        blockChainRepository.save(blockChain);
        return blockChainMapper.blockChainToBlockChainResponse(blockChain);
    }

    @Override
    public void miner(String BlockChainId, BlockRequest blockRequest) throws Exception {
        Blockchain blockChain=blockChainRepository.findById(BlockChainId).get();
        if(!isValid(blockChain)) throw new Exception("Invalid BlockChain");
        Block block=blockService.createBlock(blockRequest.getTransactions());
        block.setPreviousHash(getDernBlock(BlockChainId).getHash());
        blockService.mineBlock(blockChain.getDifficulte(),block);
        blockRepository.save(block);
        blockChain.getBlocks().add(block);
        blockChainRepository.save(blockChain);
        String transactionId=UUID.randomUUID().toString();
    }

    @Override
    public Block getDernBlock(String BlockChainId) {
        List<Block> blocks=blockChainRepository.findById(BlockChainId).get().getBlocks();
        return blocks.get(blocks.size()-1);
    }

    @Override
    public boolean isValid(Blockchain blockChain) {
        Block currentBlock;
        Block dernBlock;
        for(int i=1; i<blockChain.getBlocks().size();i++){
            System.out.println(blockChain.getBlocks().get(i));
            currentBlock=blockChain.getBlocks().get(i);
            dernBlock=blockChain.getBlocks().get(i-1);
            if(!currentBlock.getPreviousHash().equals(dernBlock.getHash())) {
                return false;
            }
            if(!currentBlock.getHash().equals(blockService.calculateBlockHash(currentBlock))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public double solde(String address) {
        List<Transaction> transactions=transactionRepository.findByadressDest(address);
        double solde=0;
        for (Transaction transaction:transactions)
            solde+=transaction.getMontant();
        return solde;
    }
}

