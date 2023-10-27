package com.example.stockApp_with_MySql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {



    @Id
    private Long stockId;
    private String stockName;
    private double stockPrice;
    private Integer stockOwnerCount;


    @Enumerated(EnumType.STRING)
    private Type stockType;
    private LocalDateTime stockCreTimeStamp;

}
