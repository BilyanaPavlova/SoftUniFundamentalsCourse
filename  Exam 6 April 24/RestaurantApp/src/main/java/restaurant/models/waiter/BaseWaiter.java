package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;
import restaurant.models.orders.TakenOrdersImpl;

import static restaurant.common.ExceptionMessages.*;

//TODO
public abstract class BaseWaiter implements Waiter{

    private String name;
    int efficiency;
    TakenOrders takenOrders;


    public BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        takenOrders = new TakenOrdersImpl();

    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEfficiency(int eff) {
        if (eff < 0){
            throw new IllegalArgumentException(WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = eff;
    }

    @Override
    public String getName(){
        return this.name;
    }

    public int getEfficiency() {
        return this.efficiency;
    }

    @Override
    public boolean canWork() {
        return this.efficiency > 0;
    }


    @Override
    public abstract void work();

    @Override
    public TakenOrders takenOrders(){
        return this.takenOrders;
    }



}
