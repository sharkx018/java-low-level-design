package Problems.pubSubSystem.subscriber;

import Problems.pubSubSystem.Message;

public interface Subscriber {
    public void onMessage(Message message);
}
