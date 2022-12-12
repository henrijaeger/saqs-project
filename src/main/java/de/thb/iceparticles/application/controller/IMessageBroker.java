package de.thb.iceparticles.application.controller;

public interface IMessageBroker {

    <T> void broadcast(String channel, T data);

}
