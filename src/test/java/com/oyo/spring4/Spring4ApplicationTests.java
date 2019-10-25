package com.oyo.spring4;

import com.oyo.spring4.integration.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring4ApplicationTests {
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void contextLoads() {
        Assert.notNull(compactDisc);
    }




}
