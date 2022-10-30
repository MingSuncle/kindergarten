package com.example.kindergarten.modules.message.dao;

import com.example.kindergarten.modules.message.entity.Message;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


    @Mapper
    public interface MessageDao extends MppBaseMapper<Message> {

        public List<Message> getAll();
    }


