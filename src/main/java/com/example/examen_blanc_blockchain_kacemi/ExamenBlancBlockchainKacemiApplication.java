package com.example.examen_blanc_blockchain_kacemi;

import com.example.examen_blanc_blockchain_kacemi.DTO.BlockChainRequest;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import com.example.examen_blanc_blockchain_kacemi.Repositories.BlockChainRepository;
import com.example.examen_blanc_blockchain_kacemi.Repositories.TransactionRepository;
import com.example.examen_blanc_blockchain_kacemi.Services.BlockService;
import com.example.examen_blanc_blockchain_kacemi.Services.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamenBlancBlockchainKacemiApplication{

    public static void main(String[] args) {
        SpringApplication.run(ExamenBlancBlockchainKacemiApplication.class, args);

    }
    /*
    @Bean
    CommandLineRunner commandLineRunner(BlockchainService blockchainService){
        return args -> {
            blockchainService.Add(new BlockChainRequest("blockKA",1 ,200.0,new ArrayList<>()));
        };
    }*/

}

