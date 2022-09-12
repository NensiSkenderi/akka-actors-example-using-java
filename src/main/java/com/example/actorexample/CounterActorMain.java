package com.example.actorexample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class CounterActorMain {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();

        ActorRef actorRef = actorSystem.actorOf(
                Props.create(CounterActor.class), "counter-actor-name");

        actorRef.tell("nensi1", ActorRef.noSender());
        actorRef.tell("nensi2", ActorRef.noSender());
        actorRef.tell("nensi3", ActorRef.noSender());
        actorRef.tell("nensi4", ActorRef.noSender());
        actorRef.tell("nensi5", ActorRef.noSender());
        actorRef.tell("nensi6", ActorRef.noSender());
        actorRef.tell("nensi7", ActorRef.noSender());
        actorRef.tell("Stop", ActorRef.noSender());
    }
}
