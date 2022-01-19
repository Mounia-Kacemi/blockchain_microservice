package com.example.examen_blanc_blockchain_kacemi.DTO;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockChainRequest {
    private String nom ;
    private int difficulte;
    private double miningReward;
    private List<Block> blocks;
}
