package com.fwtai.controller;

import com.fwtai.service.ITestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ITestService testService;

    /**
     * 简单测试提交分布式事务接口，[[[在全局事务调用者(发起全局事务的服务)的接口上加入@GlobalTransactional 即可.]]]
     * 
     * @return
     */
    // http://127.0.0.1:8081/test/seataCommit
    @GetMapping(value = "seataCommit")
    @GlobalTransactional
    public Boolean seataCommit() {
        testService.commit();
        int i=1/0;
        return true;
    }
}