package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    Repository<Climber> climberRepository;
    Repository<Mountain> mountainRepository;

    static int climbedMountains = 0;
     int removedClimbers = 0;

    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type){
            case "RockClimber":
               climber = new RockClimber(climberName);
               break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {

        Mountain mountain = new MountainImpl(mountainName);
        mountain.getPeaksList().addAll(Arrays.asList(peaks));
        mountainRepository.add(mountain);

        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climberRepository.byName(climberName);
        if (climber == null){
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }

        climberRepository.remove(climber);
        this.removedClimbers++;

        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {

        Mountain mountain = mountainRepository.getCollection().stream()
                .filter(m -> m.getName().equals(mountainName))
                .findFirst()
                .orElse(null);

        if (climberRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }

        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climberRepository.getCollection());

        climbedMountains++;

        long removedClimbers = climberRepository.getCollection().stream()
                .filter(climber -> !climber.canClimb())
                .count();

        return String.format(PEAK_CLIMBING, mountainName, removedClimbers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_MOUNTAIN_COUNT, climbedMountains)).append(System.lineSeparator())
                .append("Climber's statistics:").append(System.lineSeparator())
                .append("Name: " );

        climberRepository.getCollection()
                .forEach(climber -> sb.append(climber.getName()).append(System.lineSeparator())
                        .append("Strength: ").append(climber.getStrength()).append(System.lineSeparator())
                        .append("Conquered peaks: ").append(String.join(", ", climber.getRoster().getPeaks()))
                        .append(System.lineSeparator()));




        return sb.toString();
    }
}
