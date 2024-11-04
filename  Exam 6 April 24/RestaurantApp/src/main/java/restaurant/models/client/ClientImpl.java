package restaurant.models.client;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static restaurant.common.ExceptionMessages.*;

public class ClientImpl implements Client{

    String name;
    List<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        this.clientOrders = new LinkedList<>();
    }

    public void setName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return this.clientOrders;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
