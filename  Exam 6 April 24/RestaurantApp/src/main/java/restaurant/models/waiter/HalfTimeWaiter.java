package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

//TODO
public class HalfTimeWaiter extends BaseWaiter {

    private static final int EFFICIENCY = 4;
    public static final int EFFICIENCY_DECREASE = 2;

    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getEfficiency() {
        return super.getEfficiency();
    }

    @Override
    public void work() {
        efficiency -= EFFICIENCY_DECREASE;
        if (efficiency < 0) {
            efficiency = 0;
        }
    }



}
