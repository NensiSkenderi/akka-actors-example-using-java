package com.example.actorexample;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SimpleActor extends AbstractLoggingActor {

    private ActorRef complexActor = ActorSystem.create().actorOf(Props.create(ComplexActor.class), "complex-actor");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s-> {
                    //log().info("Sender str {}", sender());
                    log().info("Received string: {}", s);
                })
                .match(Init.class, s-> {
                    //log().info("Sender {}", sender());
                    //log().info("Received Init: {}", s.messageFromInitClass);
                    complexActor.tell("Hello11111", ActorRef.noSender());
                    self().tell(4.55555, self());
                })
                .matchAny(s-> log().info("Received the message, simple actor: {}", s))
                .build();
    }



}


