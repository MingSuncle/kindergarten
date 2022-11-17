package com.example.kindergarten.modules.message.dao;


import com.example.kindergarten.modules.message.entity.KeyMessage;
import com.example.kindergarten.modules.message.entity.Message;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeyMessageDao extends MppBaseMapper<KeyMessage> {
        public List<Message> getMessageByUserId(@Param(value = "userId")Long uerId,
                                                @Param(value = "currentPage") Integer currentPage,
                                                @Param(value= "pageSize") Integer pageSize);

        public void deleteByMessageId(@Param(value = "messageId") Long messageId);

}
