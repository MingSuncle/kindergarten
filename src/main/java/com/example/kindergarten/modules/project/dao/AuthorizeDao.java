package com.example.kindergarten.modules.project.dao;


import com.example.kindergarten.modules.project.entity.UserRight;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorizeDao extends MppBaseMapper<UserRight> {

    public List<UserRight> getAll();
}
