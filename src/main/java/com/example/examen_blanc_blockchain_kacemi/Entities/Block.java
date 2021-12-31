package com.example.examen_blanc_blockchain_kacemi.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String hash;
    private String previousHash;
    private Date date_creat;
    private int nonce;
    @OneToMany
    public ArrayList<Transaction> transactions ;
    @ManyToOne
    Blockchain blockchain;

}
