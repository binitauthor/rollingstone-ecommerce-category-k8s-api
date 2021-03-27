package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.CategoryEvent;

@Component
public class CategoryEventListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onApplicationEvent(CategoryEvent categoryEvent) {
        log.info("Received Category Event : "+categoryEvent.getEventType());
        log.info("Received Category From Category Event :"+categoryEvent.getCategory().toString());
    }
}