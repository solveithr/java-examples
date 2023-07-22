package com.inventory.management.entity;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

		@Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    @Column(name = "SKU_ID")
	    private UUID  skuId;
	    @Column(name = "SKU_NAME")
	    private String skuName;
	    @Column(name="SKU_PRICE")
	    private double skuPrice;
	    @Column(name = "SKU_ACTIVE")
	    private boolean skuActive;
	    
		@Override
		public int hashCode() {
			return Objects.hash(skuActive, skuId, skuName, skuPrice);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Inventory other = (Inventory) obj;
			return skuActive == other.skuActive && Objects.equals(skuId, other.skuId)
					&& Objects.equals(skuName, other.skuName)
					&& Double.doubleToLongBits(skuPrice) == Double.doubleToLongBits(other.skuPrice);
		}
		public UUID getSkuId() {
			return skuId;
		}
		public void setSkuId(UUID skuId) {
			this.skuId = skuId;
		}
		public String getSkuName() {
			return skuName;
		}
		public void setSkuName(String skuName) {
			this.skuName = skuName;
		}
		public double getSkuPrice() {
			return skuPrice;
		}
		public void setSkuPrice(double skuPrice) {
			this.skuPrice = skuPrice;
		}
		public boolean isSkuActive() {
			return skuActive;
		}
		public void setSkuActive(boolean skuActive) {
			this.skuActive = skuActive;
		}
		
		
}
