package com.example.kindergarten.modules.message.dao;

import com.example.kindergarten.modules.message.entity.Message;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


    @Mapper
    public interface MessageDao extends MppBaseMapper<Message> {

        public List<Message> getAll();

        /**
         * 条件查询
         * @return 返回AI消息列表
         */
        List<Message> findMessage(@Param(value="usrId") String usrId,
                                  @Param(value="proId")List proId,
                                  @Param(value="beginTime")String beginTime,
                                  @Param(value="endTime")String endTime,
                                  @Param(value="type")List type,
                                  @Param(value="currentPage")Integer currentPage,
                                  @Param(value="pageSize")Integer pageSize);

        Integer MessageNum(@Param(value="usrId") String usrId,
                                  @Param(value="proId")List proId,
                                  @Param(value="beginTime")String beginTime,
                                  @Param(value="endTime")String endTime,
                                  @Param(value="type")List type);
    }


