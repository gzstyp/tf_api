package com.fwtai.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fwtai.api.user.UserService;
import com.fwtai.entity.Test;
import com.fwtai.mapper.TestMapper;
import com.fwtai.service.ITestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper,Test> implements ITestService,UserService{

    @Override
    @Transactional//这里也要添加事务
    public Boolean commit(){
        update(Wrappers.<Test>lambdaUpdate().eq(Test::getId,1).setSql("two=two+1"));
        return true;
    }
}