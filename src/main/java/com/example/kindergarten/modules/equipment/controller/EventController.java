package com.example.kindergarten.modules.equipment.controller;


import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.equipment.dao.EventDao;
import com.example.kindergarten.modules.equipment.entity.Event;
import com.example.kindergarten.modules.equipment.service.EventService;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMPP
@Api(tags = "AI事件设置")
@ApiSupport(order = 10)
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventDao eventDao;

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation("查看所有AI事件设置")
    @GetMapping("/getAll")
    public R getAll(@RequestParam(value = "currentPage") Integer currentPage,
                    @RequestParam(value = "pageSize") Integer pageSize){
        R r = R.ok();
        List<Event> result = eventDao.getAll((currentPage - 1) * pageSize, pageSize);
        Integer totalNum = eventDao.getNum();
        r.put("result",result);
        r.put("totalNum",totalNum);
        return r;
    }

    @ApiOperation("增加/修改AI事件设置")
    @PostMapping("/addOrUpdate")
    public R addOrUpdate(@RequestBody Event event){
        R r = R.ok();
        eventService.saveOrUpdate(event);
        r.put("result","success");
        return r;
    }

    @ApiOperation("删除AI事件设置")
    @GetMapping("/delete")
    public R delete(@RequestParam(value = "eventId")Integer eventId){
        R r = R.ok();
        eventService.removeById(eventId);
        r.put("result","success");
        return r;
    }


}
