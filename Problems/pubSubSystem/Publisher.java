package Problems.pubSubSystem;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private Set<Topic> topics;

    Publisher(){
        topics = new HashSet<>();
    }

    public void registerTopic(Topic topic){
        topics.add(topic);
    }


    public void publish(Topic topic, Message message){
        if(topics.contains(topic)){
            topic.publish(message);
        }else{
            System.out.println("Topic not found: "+ topic.getName());
        }

    }

}
