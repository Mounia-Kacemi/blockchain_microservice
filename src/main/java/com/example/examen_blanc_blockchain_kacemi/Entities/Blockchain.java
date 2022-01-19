package com.example.examen_blanc_blockchain_kacemi.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blockchain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nom ;
    private Date date;
    private int difficulte;
    private double miningReward;
    @OneToMany
    List<Block> blocks;

}
