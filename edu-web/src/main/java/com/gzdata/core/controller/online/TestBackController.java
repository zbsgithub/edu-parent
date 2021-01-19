package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.gzdata.common.db.mybatis.result.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="测试控制器")
@RestController
public class TestBackController {

    private Logger logger = LoggerFactory.getLogger(TestBackController.class);

    @ApiOperation("测试方法")
    @RequestMapping("api/anon/data/test/main")
    public Result testMethod() {
        logger.info("世界你好：{}", 123);
        return Result.valueOf(Result.SUCCESS,"操作成功");
    }
}
