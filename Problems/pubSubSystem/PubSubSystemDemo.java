package Problems.pubSubSystem;

import Problems.pubSubSystem.subscriber.EmailMessage;
import Problems.pubSubSystem.subscriber.PrintMessage;
import Problems.pubSubSystem.subscriber.Subscriber;

public class PubSubSystemDemo {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Topic topic = new Topic("delivery-topic");
        publisher.registerTopic(topic);


        Subscriber s1 = new PrintMessage();
        Subscriber s2 = new EmailMessage();

        topic.registerSubscriber(s1);
        topic.registerSubscriber(s2);

        publisher.publish(topic, new Message("Hi there, Hope you have not lost your dreams!"));

    }
}
