package com.github.duorourou.onlineshopinventory.route;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/inventories")
@Log4j2
public class InventoryRouter {

    @GetMapping
    public int getInventory(@RequestParam("commodityId") String commodityId) {
        log.info("find the inventory of commodity [{}]", commodityId);
        return 0;
    }

    @GetMapping(path = "/{commodityId}")
    public int getAInventory(@PathVariable("commodityId") String commodityId) {
        throw new RuntimeException("Something happened.");
    }
}
