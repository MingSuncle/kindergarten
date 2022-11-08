package com.example.kindergarten.modules.message.controller;

import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.message.dao.KeyMessageDao;
import com.example.kindergarten.modules.message.entity.KeyMessage;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        keyMessageDao.insert(keyMessage);

        r.put("result","success");
        return r;

    }

    @ApiOperation("查看用户收藏")
    @GetMapping("/get")
    public R get(@RequestParam(value = "userId") Long userId){
        R r = R.ok();


        return r;

    }

}
