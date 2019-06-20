package models;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

public class DatabaseCustomExecutor extends CustomExecutionContext {


    @Inject
    public DatabaseCustomExecutor(ActorSystem actorSystem) {
        super(actorSystem, "database.dispatcher");
    }
}


