package com.example.examen_blanc_blockchain_kacemi.Repositories;

import com.example.examen_blanc_blockchain_kacemi.Entities.Block;
import com.example.examen_blanc_blockchain_kacemi.Entities.Blockchain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BlockChainRepository extends JpaRepository<Blockchain,String> {

}
