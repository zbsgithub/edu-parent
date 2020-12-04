package com.gzdata.core.controller.online;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.common.util.RandomUtil;
import com.gzdata.core.service.SysUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SysUsersService sysUsersService;

    /**
     * @description 描述
     *
     * @author Administrator
     * @date 2020/12/4 16:21
     * @return com.gzdata.common.db.mybatis.result.Result
     */
    @RequestMapping("api/anon/data/test/main")
    public Result testMethod() {
        logger.info("世界你好：{}", 123);
        logger.info("random num:{}", RandomUtil.generImgRandomName());
        logger.debug("nishi");

        int countNum = sysUsersService.findTotalCount();
        logger.info("技術數：{}", countNum);

        System.out.println("");

        return Result.valueOf(Result.SUCCESS, "操作成功");
    }
}
