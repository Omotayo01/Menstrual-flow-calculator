package data.repositories;

import data.models.Cycle;

import java.util.ArrayList;
import java.util.List;

public class CycleRepositoryImpl implements CycleRepository {

    private List<Cycle> cycles = new ArrayList<>();

    Cycle newCycle = new Cycle();

    @Override
    public Cycle createProfile(Cycle creator) {

        boolean userProfileHasNotBeenCreated = creator.getCycleId() == 0;
        if (userProfileHasNotBeenCreated) {
            creator.setCycleId(generateCycleId());
            cycles.add(creator);
        }

        return creator;
    }

    private int generateCycleId() {
        return cycles.size() + 1;
    }

    @Override
    public Cycle findCycleByCycleId(int profileId) {
        for (Cycle cycle: cycles){
            if (cycle.getCycleId() == profileId)
                return cycle;
        }
        return null;
    }

    @Override
    public Cycle findCycleByOwnerEmailAddress(String emailAddress) {
        for (Cycle cycle: cycles){
            if (cycle.getEmailAddress().equalsIgnoreCase(emailAddress))
                return cycle;
        }
        return null;

    }

    @Override
    public Cycle findCycleByOwnerLastname(String lastname) {
        for (Cycle cycle: cycles){
            if (cycle.getLastName().equalsIgnoreCase(lastname))
                return cycle;
        }
        return null;
    }

    @Override
    public List<Cycle> findAllProfiles() {
        return cycles;
    }

    @Override
    public void deleteByOwnerEmailAddress(String emailAddress) {
        newCycle = findCycleByOwnerEmailAddress(emailAddress);
        cycles.remove(newCycle);
    }

    @Override
    public void deleteByCycleId(int id) {
        newCycle = findCycleByCycleId(id);
        cycles.remove(newCycle);
    }

    @Override
    public void deleteByOwnerLastname(String lastname) {
        newCycle = findCycleByOwnerLastname(lastname);
        cycles.remove(newCycle);
    }

    @Override
    public void deleteAll() {
        cycles.clear();
    }

    @Override
    public long getNumberOfProfilesCreated() {
        return cycles.size();
    }
}
