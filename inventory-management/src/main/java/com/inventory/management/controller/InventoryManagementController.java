package com.inventory.management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.entity.Inventory;
import com.inventory.management.exception.ResourceNotFoundException;
import com.inventory.management.repository.InventoryRepository;

@RestController

public class InventoryManagementController {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@GetMapping("/inventory")
	public List<Inventory> getAllInventories() {
		List<Inventory> target = new ArrayList<>();
		inventoryRepository.findAll().forEach(target::add);
		return  target;
	}

	@GetMapping("/inventory/{id}")
	public ResponseEntity<Inventory> getEmployeeById(@PathVariable(value = "id") UUID skuId)
			throws ResourceNotFoundException {
		Inventory inventory = inventoryRepository.findById(skuId)
				.orElseThrow(() -> new ResourceNotFoundException("SKU not found for this id :: " + skuId));
		return ResponseEntity.ok().body(inventory);
	}

	@PostMapping("/inventory")
	public Inventory createEmployee(@Validated @RequestBody Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@PutMapping("/inventory/{id}")
	public ResponseEntity<Inventory> updateEmployee(@PathVariable(value = "id") UUID skuId,
			@Validated @RequestBody Inventory inventoryDetails) throws ResourceNotFoundException {
		Inventory inventory = inventoryRepository.findById(skuId)
				.orElseThrow(() -> new ResourceNotFoundException("SKU not found for this id :: " + skuId));

		inventory.setSkuId(inventoryDetails.getSkuId());
		inventory.setSkuName(inventoryDetails.getSkuName());
		inventory.setSkuPrice(inventoryDetails.getSkuPrice());
		inventory.setSkuActive(inventoryDetails.isSkuActive());
		final Inventory updatedInventory = inventoryRepository.save(inventory);
		return ResponseEntity.ok(updatedInventory);
	}

	@DeleteMapping("/inventory/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") UUID skuId)
			throws ResourceNotFoundException {
		Inventory inventory = inventoryRepository.findById(skuId)
				.orElseThrow(() -> new ResourceNotFoundException("SKU not found for this id :: " + skuId));

		inventoryRepository.delete(inventory);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
