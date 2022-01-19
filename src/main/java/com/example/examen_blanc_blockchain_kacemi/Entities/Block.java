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
    private Date date_creat;
    private String hash;
    private String previousHash;
    private int nonce;
    @OneToMany
    public List<Transaction> transactions ;

  /*  @ManyToOne
    Blockchain blockchain;
*/
}
