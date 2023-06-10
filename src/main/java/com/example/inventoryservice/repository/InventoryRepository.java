package com.example.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryservice.models.Inventory;

@Repository("InventoryRepository")

public interface InventoryRepository extends JpaRepository<Inventory, String>{

}
