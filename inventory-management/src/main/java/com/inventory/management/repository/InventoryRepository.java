package com.inventory.management.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.inventory.management.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, UUID> {


}
