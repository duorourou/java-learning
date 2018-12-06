package com.github.duorourou.onlineshop.commodity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@Builder
@AllArgsConstructor
public class Commodity {
    @Id
    private String id;
    private String name;
    private String subName;
    private String type;
    private int inventory;
}
