package com.example.examen_blanc_blockchain_kacemi.Web;


import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainResponse;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockRequest;
import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockChainRepository;
import com.example.examen_blanc_blockchain_kacemi.Services.BlockService;
import com.example.examen_blanc_blockchain_kacemi.Services.BlockchainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestBlock {
    private BlockChainRepository blockChainRepository;
    private BlockService blockService;
    private BlockchainService blockChainService;
    public RestBlock(BlockChainRepository blockChainRepository, BlockService blockService, BlockchainService blockChainService) {
        this.blockChainRepository = blockChainRepository;
        this.blockService = blockService;
        this.blockChainService = blockChainService;
    }
    @PostMapping("blocks")
    public Block create(@RequestBody BlockRequest blockRequest){
        return blockService.createBlock(blockRequest.getTransactions());
    }

    @GetMapping("blockchains")
    public List<Blockchain> get(){
        return blockChainRepository.findAll();
    }

    @PostMapping("AddBlockchains")
    public BlockChainResponse add(@RequestBody BlockChainRequest blockChainRequest){
        return blockChainService.Add(blockChainRequest);
    }

    @PutMapping("blockchains/miner/{id}")
    public void miner(@RequestBody BlockRequest blockRequest, @PathVariable String id ) throws Exception {
        blockChainService.miner(id,blockRequest);
    }

}
