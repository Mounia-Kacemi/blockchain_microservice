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
    public String id;
    public String nom ;
    public Date date;
    public int difficulte;
    public double miningReward;
    @OneToMany
    List<Block> blocks;

}
