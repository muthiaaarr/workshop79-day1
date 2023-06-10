package com.example.inventoryservice.models;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Inventory {
    @Id
    private String id;
    private String skuCode;
    private BigInteger stock;
}
