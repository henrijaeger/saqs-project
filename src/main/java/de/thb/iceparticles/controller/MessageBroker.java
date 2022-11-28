package de.thb.iceparticles.controller;

import de.thb.iceparticles.misc.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageBroker {

    private final SimpMessagingTemplate template;

    @Autowired
    public MessageBroker(SimpMessagingTemplate template) {
        this.template = template;
    }

    public <T> void broadcast(String channel, T data) {
        template.convertAndSend(channel, Util.toJson(data));
    }

}
