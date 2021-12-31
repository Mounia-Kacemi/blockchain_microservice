package com.example.examen_blanc_blockchain_kacemi.Services;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockRepository;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class ImplBlockService implements BlockService {
private BlockRepository blockRepository;
private Block block;

    public ImplBlockService(BlockRepository blockRepository){

    this.blockRepository=blockRepository;
}

    @Override
    public String calculateBlockHash(Block block) {
        String dataToHash = block.getPreviousHash()
                + block.getDate_creat()
                + Integer.toString(block.getNonce())
                ;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException ex) {
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }
    @Override
    public String mineBlock(int difficulty,Block block) {
        String prefixString = new String(new char[difficulty]).replace('\0', '0');
        String hash = block.getHash();

        int iteration =0;
        while (!hash.substring(0,difficulty).equals(prefixString)) {
            System.out.println(iteration++);
            block.setNonce(block.getNonce()+1);
            hash = this.calculateBlockHash(block);
        }
        System.out.println(hash);
        return hash;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        return false;
    }

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }
}
