package com.github.duorourou.onlineshop.commodity.route;

import com.github.duorourou.onlineshop.commodity.client.InventoryClient;
import com.github.duorourou.onlineshop.commodity.data.CommodityRepository;
import com.github.duorourou.onlineshop.commodity.domain.Commodity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "commodities")
@Log4j2
public class CommodityRouter {
    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    InventoryClient inventoryClient;

    @GetMapping
    public Flux<Commodity> list() {
        return commodityRepository.findAll();
    }

    @PostMapping
    public Mono<Commodity> create(@RequestBody Commodity commodity) {
        log.info("commodity creating");
        Mono<Commodity> newOne = commodityRepository.save(commodity);
        return newOne.doAfterSuccessOrError((c, err) -> c.setInventory(inventoryClient.getInventory(c.getId())));
    }

    @GetMapping(path = "/{id}")
    public Mono<Commodity> get(@PathVariable("id") String id) {
        Mono<Commodity> commodity = commodityRepository.findById(id);
        return commodity.map(c -> {
            c.setInventory(inventoryClient.getAInventory(id));
            return c;
        });
    }
}
