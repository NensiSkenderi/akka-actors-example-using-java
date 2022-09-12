package com.example.actorexample;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;

public class ClassicActorExample extends AbstractLoggingActor {

    //this defines which messages your Actor can handle, along with
    //the implementation of how messages should be processed

    @Override
    public void preStart() throws Exception {
        super.preStart();
        self().tell(new Init(), ActorRef.noSender());
    }


    @Override
    public Receive createReceive() {
        //we can build such a behavior with a builder name ReceiveBuilder
        return receiveBuilder()
                .match(Init.class, s -> log().info("Initialized"))
                .match(String.class,
                        s -> log().info("Received String message {}", s)
                )
                .matchAny(any -> log().info("Received unknown message"))
                .build();
    }

    //since akka actor loop message is exhaustive, it means that
    //we need to provide a pattern match for all messages that it can accept

    public static class Init {}
}


