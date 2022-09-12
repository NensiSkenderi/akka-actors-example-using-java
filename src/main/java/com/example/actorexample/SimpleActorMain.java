package com.example.actorexample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SimpleActorMain {

    public static void main(String[] args) {
        ActorSystem a = ActorSystem.create();

        ActorRef simpleActor = a.actorOf(Props.create(SimpleActor.class), "name-of-actor");
        //simpleActor.tell("hello", ActorRef.noSender());
        simpleActor.tell(1.4, ActorRef.noSender());

        //the receiver is SimpleActor
        //we dont send init, we send object of class Init
        //no sender
        simpleActor.tell(new Init("message from init"), ActorRef.noSender());


    }

}
