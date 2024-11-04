package restaurant.models.orders;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TakenOrdersImpl implements TakenOrders{

    List <String> ordersList;

    public TakenOrdersImpl() {
        this.ordersList = new LinkedList<>();
    }

    @Override
    public Collection<String> getOrdersList() {
        return this.ordersList;
    }
}
