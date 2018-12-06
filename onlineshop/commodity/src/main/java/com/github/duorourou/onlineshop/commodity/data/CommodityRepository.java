package com.github.duorourou.onlineshop.commodity.data;

import com.github.duorourou.onlineshop.commodity.domain.Commodity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommodityRepository extends ReactiveMongoRepository<Commodity, String> {
}
