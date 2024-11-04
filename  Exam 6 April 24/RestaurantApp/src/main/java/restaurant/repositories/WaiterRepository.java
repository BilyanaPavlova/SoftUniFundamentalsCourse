package restaurant.repositories;


import restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class WaiterRepository implements Repository<Waiter>{

    private final Collection <Waiter> waiters;

    public WaiterRepository (){
        this.waiters = new LinkedList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(waiters);

    }

    @Override
    public void add(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
            return waiters.remove(waiter);
    }

    @Override
    public Waiter byName(String name) {
        return waiters.stream()
                .filter(waiter -> waiter.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
