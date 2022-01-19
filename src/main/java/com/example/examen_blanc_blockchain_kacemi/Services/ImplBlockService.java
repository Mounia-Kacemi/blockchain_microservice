package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockRepository;
import com.example.examen_blanc_blockchain_kacemi.mappers.BlockMapper;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ImplBlockService implements BlockService {

   // private BlockMapper blockMapper;
    private BlockRepository blockRepository;

    public ImplBlockService(BlockRepository blockRepository) {
       // this.blockMapper = blockMapper;
        this.blockRepository = blockRepository;
    }

    @Override
    public Block createBlock(List<Transaction> transactions) {
        Block block=new Block();
        block.setTransactions(transactions);
        block.setDate_creat(new Date());
        block.setNonce(0);
        block.setId(UUID.randomUUID().toString());
        blockRepository.save(block);
        return block;

    }

    @Override
    public String calculateBlockHash(Block block) {

        String toHash=block.getPreviousHash()+block.getNonce()+block.getTransactions().hashCode();
        return  Hashing.sha256()
                .hashString(toHash, StandardCharsets.UTF_8)
                .toString();

    }

    @Override
    public void mineBlock(int difficulty,Block block) {
        String zeros=new String(new char[difficulty]).replace('\0','0');
        while(true){
            String hash=calculateBlockHash(block);
            block.setNonce(block.getNonce()+1);
            if(hash.substring(0,difficulty).equals(zeros)){
                block.setHash(hash);
                return ;
            }
        }

    }
}
