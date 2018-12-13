package com.github.duorourou.springintegration.demo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CellphoneCreatedEvent {
    private Cellphone cellphone;
    private Date createdDate;
}
