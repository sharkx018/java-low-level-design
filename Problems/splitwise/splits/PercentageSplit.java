package Problems.splitwise.splits;

import Problems.splitwise.User;

public class PercentageSplit extends Split{

    private double percent;

    public PercentageSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    public double getPercent() {
        return percent;
    }
}
