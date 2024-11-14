package Problems.pubSubSystem;


import Problems.pubSubSystem.subscriber.Subscriber;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {

    private String name;
    private Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name){
        this.name = name;
    }

    public void publish(Message message){
        for(Subscriber subscriber: subscribers){
            subscriber.onMessage(message);
        }
    }

    public void registerSubscriber(Subscriber s){
        this.subscribers.add(s);
    }

    public void removeSubscriber(Subscriber s){
        this.subscribers.remove(s);
    }

    public String getName() {
        return name;
    }
}
