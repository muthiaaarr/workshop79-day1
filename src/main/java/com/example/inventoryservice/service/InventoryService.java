package com.example.inventoryservice.service;

import com.example.inventoryservice.repository.InventoryRepository;
import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.models.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Inventory createInventory(InventoryRequest inventoryRequest) {
        Inventory newInventory = Inventory.builder()
                .id(inventoryRequest.getId())
                .skuCode(inventoryRequest.getSkuCode())
                .stock(inventoryRequest.getStock())
                .build();

        return inventoryRepository.save(newInventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventory(String id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);

        if (inventory.isPresent()) {
            return inventory.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
        }
    }

    public Inventory updateInventory(String id, InventoryRequest inventoryRequest) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);

        if (inventory.isPresent()) {
            Inventory updateInventory = inventory.get();

            updateInventory.setId(inventoryRequest.getId());
            updateInventory.setSkuCode(inventoryRequest.getSkuCode());
            updateInventory.setStock(inventoryRequest.getStock());

            return inventoryRepository.save(updateInventory);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
        }
    }

    public String deleteInventory(String id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);

        if (inventory.isPresent()) {
            inventoryRepository.deleteById(id);
            return "Inventory deleted";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
        }
    }


}

