package com.gzdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主程序
 *
 * @author 张兵帅
 * @since 2019年7月23日
 */
@EnableSwagger2
//@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.gzdata","com.baidu.ueditor"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
