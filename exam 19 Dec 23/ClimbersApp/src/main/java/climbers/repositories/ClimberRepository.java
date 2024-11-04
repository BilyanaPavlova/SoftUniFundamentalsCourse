package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClimberRepository implements Repository<Climber>{

    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new LinkedList<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(climbers);
    }

    @Override
    public void add(Climber climber) {
        this.climbers.add(climber);
    }

    @Override
    public boolean remove(Climber climber) {
        return climbers.remove(climber);
    }

    @Override
    public Climber byName(String name) {
       return climbers.stream()
                .filter(climber -> climber.getName().equals(name))
                .findFirst()
                .orElse(null);


    }
}
