package com.github.duorourou.onlineshop.commodity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory", path = "/inventories",
        fallback = InventoryFallback.class, primary = true)
public interface InventoryClient {

    @GetMapping
    int getInventory(@RequestParam("commodityId") String commodityId);

    @GetMapping(path = "/{commodityId}")
    int getAInventory(@PathVariable("commodityId") String commodityId);
}
