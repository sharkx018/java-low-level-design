package Problems.splitwise.splits;

import Problems.splitwise.User;

public class ExactSplit extends Split{

    public ExactSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
