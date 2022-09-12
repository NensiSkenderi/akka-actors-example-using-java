package com.example.actorexample;

import akka.actor.AbstractLoggingActor;

public class ComplexActor extends AbstractLoggingActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Double.class, message ->  {
                    log().info("double message {} ", message);
                })
                .match(SimpleActor.class, s-> log().info("from simple actor"))
                .matchAny(s-> log().info("Matched any, complex actor"))
                .build();
    }
}
