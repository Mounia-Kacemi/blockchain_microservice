package com.example.examen_blanc_blockchain_kacemi.mappers;


import com.example.examen_blanc_blockchain_kacemi.DTO.TransactionRequest;
import com.example.examen_blanc_blockchain_kacemi.DTO.TransactionResponse;
import com.example.examen_blanc_blockchain_kacemi.Entities.Transaction;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionResponse transactionToTransactionResponse(Transaction transaction);
    Transaction transactionRequestToTransaction(TransactionRequest transactionRequest);
}