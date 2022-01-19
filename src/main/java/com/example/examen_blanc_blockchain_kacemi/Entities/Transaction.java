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
   private String id;
   private Date date_trans;
   private String adressSource ;
   private String adressDest;
   private double montant;
    @ManyToOne
 Block block;
}
