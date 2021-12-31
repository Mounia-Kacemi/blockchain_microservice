package com.example.examen_blanc_blockchain_kacemi.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public Date date_trans;
    public String adressSource ;
    public String adressDest;
    public double montant;
    @ManyToOne
 Block block;
}
