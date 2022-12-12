package de.thb.iceparticles.controller;

public interface IMessageBroker {

    <T> void broadcast(String channel, T data);

}
