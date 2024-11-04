package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Iterator;

public class ClimbingImpl implements Climbing{

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        for (Climber climber : climbers) {
            Iterator<String> peakIterator = mountain.getPeaksList().iterator();
            while (peakIterator.hasNext() && climber.canClimb()) {
                String peak = peakIterator.next();
                climber.climb();
                climber.getRoster().getPeaks().add(peak);
                peakIterator.remove();
            }
        }
    }

}
