package utils;

import data.models.Cycle;
import dtos.requests.CreateCycleProfileRequest;
import dtos.responses.FindCreatedCycleResponse;

public class Mapper {

    public static Cycle map(CreateCycleProfileRequest registerRequest){
        Cycle cycle = new Cycle();
        cycle.setFirstName(registerRequest.getFirstName());
        cycle.setLastName(registerRequest.getLastName());
        cycle.setEmailAddress(registerRequest.getEmailAddress());
        cycle.setCycleLength(registerRequest.getCycleLength());
        cycle.setPeriodDuration(registerRequest.getPeriodDuration());
        cycle.setDateBefore(registerRequest.getFirstDayOfLastFlow());
        return cycle;
    }

    public static void map(Cycle foundCycle, FindCreatedCycleResponse response) {
        response.setId(foundCycle.getCycleId());
        response.setCycleLength(foundCycle.getCycleLength());
        response.setEmailAddress(foundCycle.getEmailAddress());
        response.setFirstName(foundCycle.getFirstName());
        response.setLastName(foundCycle.getLastName());
        response.setFirstDayOfLastFlow(foundCycle.getDateBefore());
        response.setPeriodDuration(foundCycle.getPeriodDuration());

    }
}
