package com.github.duorourou.springintegration.demo.user;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class CreateCellphoneCmd {
    private Cellphone cellphone;
    private String currentUser;
    private Date occurreddDate;
}
