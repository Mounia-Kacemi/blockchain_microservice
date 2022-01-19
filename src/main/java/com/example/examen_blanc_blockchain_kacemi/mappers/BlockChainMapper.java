package com.example.examen_blanc_blockchain_kacemi.mappers;


import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainResponse;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockChainMapper {
    BlockChainResponse blockChainToBlockChainResponse(Blockchain blockChain);
    Blockchain blockChainRequestToBlockChain(BlockChainRequest blockChainRequest);
}