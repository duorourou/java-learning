package com.github.duorourou.springintegration.demo.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cellphone {
    private String id;
    private String name;
    private String sn;
    private int ram;
    private int rom;
    private String ramUnit = "G";
    private String romUnit = "G";
    private PurchaseType purchaseType = PurchaseType.SELF_SUPPORTING;
}
