package climbers.models.roster;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class RosterImpl implements Roster {

    Collection<String> peaks;

    public RosterImpl() {
        this.peaks = new LinkedList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return this.peaks;
    }
}
