package org.zwx.audit.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.zwx.audit.applicaion.BakConfigParse;
import org.zwx.audit.applicaion.SystemConifg;
import org.zwx.audit.model.BakConfig;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestParser {

    @Mock
    private SystemConifg systemConifg;


    @InjectMocks private BakConfigParse parser;

    @Before
    public void set() {
//        systemConifg = mock(SystemConifg.class);
        when(systemConifg.getValue("BAK_CONF_PATH")).thenReturn("etc/bak_conf.json");
    }

    @Test
    public void testParse() {
//        parser = new BakConfigParse();
        List<BakConfig> configList = parser.parse();
        Assert.assertEquals(configList.size(), 2);
    }
}
