package de.thb.iceparticles.controller;

import de.thb.iceparticles.controller.domain.Response;
import de.thb.iceparticles.misc.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageBroker implements IMessageBroker {

    private final SimpMessagingTemplate template;

    @Autowired
    public MessageBroker(SimpMessagingTemplate template) {
        this.template = template;
    }

    public <T> void broadcast(String channel, T data) {
        template.convertAndSend(channel, Util.toJson(Response.builder().status(HttpStatus.OK).value(data).build()));
    }

}
