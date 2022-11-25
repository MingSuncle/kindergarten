package com.example.kindergarten.modules.equipment.dao;

import com.example.kindergarten.modules.equipment.entity.Event;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventDao extends MppBaseMapper<Event> {

    public List<Event> getAll(@Param(value = "currentPage") Integer currentPage,
                              @Param(value = "pageSize")Integer pageSize);

    public Integer getNum();
}
