package com.gzdata.core.controller.online;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/data/test/main")
    public void testMethod() {
        logger.info("世界你好：{}", 123);
    }
}
