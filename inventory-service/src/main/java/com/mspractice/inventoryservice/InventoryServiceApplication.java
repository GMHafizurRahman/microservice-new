package com.mspractice.inventoryservice;

import com.mspractice.inventoryservice.model.Inventory;
import com.mspractice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner LoadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iPhone_13");
            inventory.setQuantity(100);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iPhone_13_red");
            inventory2.setQuantity(0);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory2);
        };
    }

}
