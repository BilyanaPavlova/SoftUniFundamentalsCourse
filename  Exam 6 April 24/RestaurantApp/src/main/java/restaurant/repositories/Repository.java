package restaurant.repositories;

import restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T waiter);

    boolean remove(T entity);

    T byName(String name);
}
