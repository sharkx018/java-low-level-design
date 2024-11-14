package Problems.pubSubSystem.subscriber;

import Problems.pubSubSystem.Message;

public class PrintMessage implements Subscriber {

    @Override
    public void onMessage(Message message) {
        System.out.println("Print Message: "+message.getMessage());
    }
}
