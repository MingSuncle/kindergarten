package com.example.kindergarten.modules.equipment.service.impl;


import com.example.kindergarten.modules.equipment.dao.VideoDao;
import com.example.kindergarten.modules.equipment.entity.Video;
import com.example.kindergarten.modules.equipment.service.VideoService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service("VideoService")
public class VideoServiceImpl
        extends MppServiceImpl<VideoDao, Video> implements VideoService {
}
