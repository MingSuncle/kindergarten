package com.example.kindergarten.modules.equipment.dao;


import com.example.kindergarten.modules.equipment.entity.Video;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoDao extends MppBaseMapper<Video> {

    public List<Video> getByBoxId(@Param(value = "boxId")String boxId,
                                  @Param(value = "currentPage")Integer currentPage,
                                  @Param(value = "pageSize")Integer pageSize);

    public Integer getNumByBoxId(@Param(value = "boxId")String boxId);
}
