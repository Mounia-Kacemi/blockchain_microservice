package com.example.examen_blanc_blockchain_kacemi.mappers;


import com.example.examen_blanc_blockchain_kacemi.DTO.BlockRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.BlockResponse;
import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")
public interface BlockMapper {
    BlockResponse blockToBlockResponse(Block block);
    Block blockRequestToBlock(BlockRequest blockRequest);
}