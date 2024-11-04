package restaurant.repositories;

import restaurant.models.client.Client;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ClientRepository implements Repository <Client>{

    private final Collection<Client> clients;

    public ClientRepository(){
        this.clients = new LinkedList<>();
    }

    @Override
    public Collection <Client> getCollection() {
        return this.clients;
    }

    @Override
    public void add(Client client) {

        clients.add((Client)client);

    }

    @Override
    public boolean remove(Client client) {
        return clients.remove(client);
    }

    @Override
    public Client byName(String name) {
        return clients.stream()
                .filter(client -> client.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
