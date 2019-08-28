package com.oyo.spring4;

import com.oyo.spring4.integration.CompactDisc;
import com.oyo.spring4.start.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liurui
 * @date 2019/8/28 19:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CDPlayerTest {
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void test() {
        Assert.assertNotNull(compactDisc);
    }
}
