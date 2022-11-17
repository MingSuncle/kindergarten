package com.example.kindergarten.modules.message.controller;

import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.message.dao.KeyMessageDao;
import com.example.kindergarten.modules.message.entity.KeyMessage;
import com.example.kindergarten.modules.message.entity.Message;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "收藏AI消息")
@ApiSupport(order = 10)
@RestController
@RequestMapping("/KeyMessage")
public class KeyMessageController {
    @Autowired
    private KeyMessageDao keyMessageDao;

    @ApiOperation("收藏消息")
    @GetMapping("/add")
    public R add(@RequestParam(value = "userId")Long userId,
                 @RequestParam(value = "messageId")Long messageId){
        R r = R.ok();
        KeyMessage keyMessage = new KeyMessage();
        keyMessage.setMessageId(messageId);
        keyMessage.setUserId(userId);
        //后期要加上图片转移到不自动删除的文件夹
        keyMessageDao.insert(keyMessage);

        r.put("result","success");
        return r;

    }

    @ApiOperation("查看用户收藏")
    @GetMapping("/get")
    public R get(@RequestParam(value = "userId") Long userId,
                 @RequestParam(value = "currentPage")Integer currentPage,
                 @RequestParam(value = "pageSize") Integer pageSize){
        R r = R.ok();
        List<Message> result = keyMessageDao.getMessageByUserId(userId,(currentPage - 1) * pageSize,pageSize);
        r.put("result",result);
        return r;

    }

    @ApiOperation("取消收藏")
    @GetMapping("/delete")
    public R delete(@RequestParam(value = "message_id") Long messageId)
    {
        R r = R.ok();
        keyMessageDao.deleteByMessageId(messageId);
        r.put("result","success");
        return r;
    }




}
