package com.example.kindergarten.modules.equipment.service.impl;


import com.example.kindergarten.modules.equipment.dao.EventDao;
import com.example.kindergarten.modules.equipment.entity.Event;
import com.example.kindergarten.modules.equipment.service.EventService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service("EventService")
public class EventServiceImpl extends
        MppServiceImpl<EventDao, Event> implements EventService {
}
