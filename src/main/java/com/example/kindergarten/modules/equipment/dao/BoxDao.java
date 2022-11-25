package com.example.kindergarten.modules.equipment.dao;

import com.example.kindergarten.modules.equipment.entity.Box;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoxDao extends MppBaseMapper<Box> {
    public List<Box> getBoxByUserId(@Param(value = "userId") Long userId,
                                    @Param(value = "currentPage") Integer currentPage,
                                    @Param(value = "pageSize")Integer pageSize);

    public Integer getBoxNumByUserId(@Param(value = "userId") Long userId);

    public List<Box> getBoxByProjectId(@Param(value = "projectId")String projectId,
                                       @Param(value = "currentPage") Integer currentPage,
                                       @Param(value = "pageSize")Integer pageSize);

    public Integer getBoxNumByProjectId(@Param(value = "projectId") String projectId);
}
