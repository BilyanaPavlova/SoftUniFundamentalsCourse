package climbers.repositories;

import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MountainRepository implements Repository<Mountain>{

    private Collection<Mountain> mountains;

    public MountainRepository() {
        this.mountains = new LinkedList<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains);
    }

    @Override
    public void add(Mountain mountain) {
        this.mountains.add(mountain);

    }

    @Override
    public boolean remove(Mountain mountain) {
        return this.mountains.remove(mountain);
    }

    @Override
    public Mountain byName(String name) {
        return mountains.stream()
                .filter(mount -> mount.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
