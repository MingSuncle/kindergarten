package com.example.kindergarten.modules.project.dao;


import com.example.kindergarten.modules.project.entity.Project;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProjectDao extends MppBaseMapper<Project> {
    public List<Project> getAll();

}
