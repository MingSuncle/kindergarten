package com.example.kindergarten.modules.project.dao;


import com.example.kindergarten.modules.project.entity.UserRight;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorizeDao extends MppBaseMapper<UserRight> {

    public List<UserRight> getAll(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);

    public List<UserRight> find(@Param("userId") Integer userId,@Param("projectId") String projectId);
}
