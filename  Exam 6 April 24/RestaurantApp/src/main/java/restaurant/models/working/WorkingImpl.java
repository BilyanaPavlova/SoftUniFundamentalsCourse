package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Iterator;

public class WorkingImpl implements Working{

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
// !!!!!!!!!!!!!!!!!!!!!!!!!
// waiters is a Collection. Ако искаме да го итерираме,ЕДИНСТВЕНИЯТ начин да итерираме Collection
// е да му пуснем итератор по него,
// защото ние не знаем тоя Collection отдолу какво е: List , Set, Queue..
        /*
        Using an iterator for the Collection<Waiter> is necessary because the Collection interface
        does not guarantee a specific implementation (e.g., List, Set).
        The iterator provides a uniform way to traverse the elements regardless of the underlying collection type.
        This ensures that the code can handle any type of Collection
        without needing to know its specific implementation.
        Ако колекцията е Мап, тогава итераторът е по values на мапа:
                Iterator<Waiter> waiterIterator = waiters.values().iterator();

         */

        /*
        Yes, an array in Java is considered a collection of elements,
        but it does not implement the Collection interface from the Java Collections Framework.
        Arrays have a fixed size and provide direct access to their elements,
         whereas collections like List, Set,
        and Map are more flexible and provide additional methods for manipulating the elements.
         */

        /*
        Does Map inherits Collection

        No, the Map interface is not an inheritor of the Collection interface.
        They are both part of the Java Collections Framework but serve different purposes.
        The Collection interface is a root interface for collections of objects,
        such as List, Set, and Queue.
        The Map interface, on the other hand, represents a collection of key-value pairs
        and is not a subtype of Collection.  Here is a brief summary:

        Collection: Root interface for collections of objects (e.g., List, Set, Queue).
        Map: Interface for collections of key-value pairs.
         */

        /*
        Why we use Collection
        Using a Collection<Waiter> instead of a specific type like List<Waiter> or Set<Waiter>
        provides flexibility and abstraction. Here are the reasons:

Abstraction: The Collection interface is more abstract than List or Set,
allowing the method to accept any type of collection that implements Collection.
This makes the code more flexible and reusable.

Implementation Agnostic: By using Collection, the method does not need to know
the specific implementation of the collection. It can work with any collection type,
whether it's a List, Set, or any other class that implements Collection.

Future-Proofing: If the underlying collection type needs to change in the future,
the method signature does not need to be modified. This reduces the risk of breaking changes
and makes the code easier to maintain.
         */
        Iterator<Waiter> waiterIterator = waiters.iterator();

        while (!client.getClientOrders().isEmpty() && waiterIterator.hasNext()) {
            Waiter waiter = waiterIterator.next();

            while (waiter.canWork() && !client.getClientOrders().isEmpty()) {
                String order = client.getClientOrders().iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                waiter.work();
                client.getClientOrders().remove(order);
            }
        }
    }


}
