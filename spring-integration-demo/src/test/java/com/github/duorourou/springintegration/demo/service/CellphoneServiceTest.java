package com.github.duorourou.springintegration.demo.service;

import com.github.duorourou.springintegration.demo.user.Cellphone;
import com.github.duorourou.springintegration.demo.user.CreateCellphoneCmd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CellphoneServiceTest {

    @Autowired
    CellphoneService cellphoneService;

    @Test
    public void shouldCreateACellphone() {
        Cellphone aCellphone = Cellphone.builder()
                .name("Huawei Mate20 Pro")
                .sn("69458dk8989")
                .ram(6)
                .rom(64)
                .build();
        CreateCellphoneCmd cmd = CreateCellphoneCmd.builder()
                .cellphone(aCellphone)
                .currentUser("Administrator")
                .occurreddDate(new Date()).build();

        assert cellphoneService.createCellphone(cmd);
    }
}