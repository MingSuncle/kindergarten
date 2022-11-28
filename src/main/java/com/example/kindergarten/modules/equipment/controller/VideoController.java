package com.example.kindergarten.modules.equipment.controller;


import com.example.kindergarten.common.utils.R;
import com.example.kindergarten.modules.equipment.dao.VideoDao;
import com.example.kindergarten.modules.equipment.entity.Video;
import com.example.kindergarten.modules.equipment.service.VideoService;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMPP
@Api(tags = "摄像头设置")
@ApiSupport(order = 10)
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoDao videoDao;

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @ApiOperation("根据盒子ID查看下属摄像头信息")
    @GetMapping("/getVideoByBoxId")
    public R getVideoByBoxId(@RequestParam(value = "boxId")String boxId,
                             @RequestParam(value = "currentPage")Integer currentPage,
                             @RequestParam(value = "pageSize")Integer pageSize){
        R r = R.ok();
        List<Video> result = videoDao.getByBoxId(boxId,(currentPage - 1) * pageSize,pageSize);
        Integer totalNum = videoDao.getNumByBoxId(boxId);
        r.put("totalNum",totalNum);
        r.put("result",result);
        return r;
    }

    @ApiOperation("修改摄像头信息")
    @PostMapping("/modifyVideo")
    public R modifyVideo(@RequestBody Video video){
        R r = R.ok();
        videoService.saveOrUpdate(video);
        r.put("result","success");
        return r;
    }
}
