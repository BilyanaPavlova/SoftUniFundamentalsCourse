package climbers.models.mountain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static climbers.common.ExceptionMessages.*;

public class MountainImpl implements Mountain{

    String name;
    Collection<String> peaksList;


    public MountainImpl(String name) {
        setName(name);
        this.peaksList = new LinkedList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(MOUNTAIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return this.peaksList;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
