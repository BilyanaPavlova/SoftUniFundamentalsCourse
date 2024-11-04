package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.WaiterRepository;

import java.util.*;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{



    private final WaiterRepository waiters;
    private final ClientRepository clients;
    private final WorkingImpl working;
    int countOfClientsServed;

    public ControllerImpl() {
        this.waiters = new WaiterRepository();
        this.clients = new ClientRepository();
        this.working = new WorkingImpl();
        countOfClientsServed = 0;
    }


    @Override
    public String addWaiter(String type, String waiterName) {

            Waiter waiter;
            switch (type) {
                case "FullTimeWaiter":
                    waiter = new FullTimeWaiter(waiterName);
                    break;
                case "HalfTimeWaiter":
                    waiter = new HalfTimeWaiter(waiterName);
                    break;
                default:
                    throw new IllegalArgumentException(WAITER_INVALID_TYPE);
            }
            waiters.add(waiter);
            return String.format(WAITER_ADDED, type, waiterName);
        }

        /*
        AddClient Command
Parameters
•	clientName - String
•	getClientOrders – String... (Varargs)
Functionality
Create a client with the provided getClientOrders and name and save it in the repository.
The method should return the following message:
•	"Added Client: {clientName}."
      */

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clients.add(client);
        return String.format(CLIENT_ADDED, client.getName());
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiters.byName(waiterName);

        if (!waiters.remove(waiter)){
           throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }

        return String.format(WAITER_REMOVE, waiterName);

    }

    @Override
    public String removeClient(String clientName) {

        Client client = clients.byName(clientName);

        if (!clients.remove(client)){
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }

        return String.format(CLIENT_REMOVE, clientName);

    }

    @Override
    public String startWorking(String clientName) {

        Client client = clients.byName(clientName);

        if (this.waiters.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        this.working.takingOrders(client, this.waiters.getCollection());

        countOfClientsServed++;
        return String.format(ORDERS_SERVING, client.getName());
    }

    @Override
    public String getStatistics() {
    StringBuilder strb = new StringBuilder();

    if (this.countOfClientsServed == 0) {
        strb.append("None clients were served.")
            .append(System.lineSeparator());
    } else {
        strb.append(String.format(FINAL_CLIENTS_COUNT, this.countOfClientsServed))
            .append(System.lineSeparator());
    }

    strb.append(FINAL_WAITERS_STATISTICS)
        .append(System.lineSeparator());

    for (Waiter waiter : this.waiters.getCollection()) {
        strb.append(String.format(FINAL_WAITER_NAME, waiter.getName()))
            .append(System.lineSeparator())
            .append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()))
            .append(System.lineSeparator())
                .append(String.format(FINAL_WAITER_ORDERS,
                        waiter.takenOrders().getOrdersList().isEmpty()
                                ? "None"
                                : String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList())))
                .append(System.lineSeparator());
    }

    return strb.toString();
}
}
