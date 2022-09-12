package com.example.actorexample;

import akka.actor.AbstractLoggingActor;

public class CounterActor extends AbstractLoggingActor {

    private int count = 0;

    @Override
    public Receive createReceive() {
        //TODO should record number of times it receives messages
        //TODO should stop actor when receiving "Stop"
        //TODO should log all messages
        return receiveBuilder()
                .match(String.class, message -> {
                    count++;
                    log().info("Received message {} with count {}", message, count);
                    if(message.equals("Stop")) {
                        log().info("Actor is stopping {}", count);
                        getContext().stop(getSelf());
                    }
                })
                .build();
    }

    //method useful for testing purposes
    private int getCount() {
        return count;
    }
}
