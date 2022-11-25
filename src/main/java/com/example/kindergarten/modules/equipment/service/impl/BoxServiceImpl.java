package com.example.kindergarten.modules.equipment.service.impl;


import com.example.kindergarten.modules.equipment.dao.BoxDao;
import com.example.kindergarten.modules.equipment.entity.Box;
import com.example.kindergarten.modules.equipment.service.BoxService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service("BoxService")
public class BoxServiceImpl extends
        MppServiceImpl<BoxDao,Box> implements BoxService {
}
