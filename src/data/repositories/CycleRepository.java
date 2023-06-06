package data.repositories;

import data.models.Cycle;

import java.util.List;

public interface CycleRepository {

    Cycle createProfile(Cycle creator);

    Cycle findCycleByCycleId(int profileId);

    Cycle findCycleByOwnerEmailAddress(String emailAddress);

    Cycle findCycleByOwnerLastname(String lastname);

    List<Cycle> findAllProfiles();

    void deleteByOwnerEmailAddress (String emailAddress);

    void deleteByCycleId(int id);

    void deleteByOwnerLastname(String lastname);

    void deleteAll();

    long getNumberOfProfilesCreated();
}