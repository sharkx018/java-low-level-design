package Problems.pubSubSystem.subscriber;

import Problems.pubSubSystem.Message;

public class EmailMessage implements Subscriber{
    @Override
    public void onMessage(Message message) {
        System.out.println("Email Message: " + message.getMessage());
    }
}
