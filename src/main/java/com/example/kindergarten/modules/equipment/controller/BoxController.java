package com.example.kindergarten.modules.equipment.controller;


import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.equipment.dao.BoxDao;
import com.example.kindergarten.modules.equipment.entity.Box;
import com.example.kindergarten.modules.equipment.service.EventService;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableMPP
@Api(tags = "盒子设置")
@ApiSupport(order = 10)
@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    private BoxDao boxDao;

    private final EventService eventService;

    public BoxController(EventService eventService) {
        this.eventService = eventService;
    }


    @ApiOperation("根据用户ID查看盒子信息")
    @GetMapping("/getBoxByUserId")
    public R getBoxByUserId(@RequestParam(value = "user_id")Long userId,
                            @RequestParam(value = "current_page")Integer currentPage,
                            @RequestParam(value = "page_size")Integer pageSize){
        R r = R.ok();
        List<Box> result = boxDao.getBoxByUserId(userId,(currentPage - 1) * pageSize,pageSize);
        Integer totalNum = boxDao.getBoxNumByUserId(userId);
        r.put("totalNum",totalNum);
        r.put("result",result);
        return r;
    }

    @ApiOperation("修改盒子信息")
    @GetMapping("/update")
    public R update(@RequestBody Box Box){
        R r = R.ok();

        return r;
    }
}
