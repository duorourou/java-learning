package com.github.duorourou.onlineshop.commodity.client;

import org.springframework.stereotype.Component;

@Component("inventoryClient ")
public class InventoryFallback implements InventoryClient {

    @Override
    public int getInventory(String commodityId) {
        return 10;
    }

    @Override
    public int getAInventory(String commodityId) {
        return 10;
    }
}
