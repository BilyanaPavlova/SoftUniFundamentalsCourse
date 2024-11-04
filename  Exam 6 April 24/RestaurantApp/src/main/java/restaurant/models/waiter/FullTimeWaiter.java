package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

import java.util.Collection;
import java.util.List;

//TODO
public class FullTimeWaiter extends BaseWaiter{

    private static final int EFFICIENCY = 8;
    public static final int EFFICIENCY_DECREASE = 1;

    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY); // passes the concrete efficiency  to the base class constructor
    }

    @Override
    public void work() {
        efficiency -= EFFICIENCY_DECREASE;
        if (efficiency < 0) {
            efficiency = 0;
        }
    }


}
