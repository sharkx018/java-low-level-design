package Problems.splitwise.splits;

import Problems.splitwise.User;

public class EqualSplit extends Split{

    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
