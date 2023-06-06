package services;

import data.models.Cycle;

import dtos.requests.CreateCycleProfileRequest;

import dtos.responses.FindCreatedCycleResponse;

import java.text.ParseException;
import java.util.List;

public interface CycleService {

    Cycle createProfile(CreateCycleProfileRequest request);


    List<String> calculateFlowDateForTwelveMonths(String mailAddress, int numberOfMonths,
                                                  String dateOfLastPeriod, int lengthOfCycle) ;

    List<String> calculateOvulationDateForTwelveMonths(String mailAddress, int numberOfMonths,
                                          String dateOfLastPeriod, int lengthOfCycle) ;

    List<String> calculateSafePeriodDateForTwelveMonths(String mailAddress, int numberOfMonths,
                                          String dateOfLastPeriod, int lengthOfCycle) ;


    FindCreatedCycleResponse findByProfileId(int id);


    FindCreatedCycleResponse findByOwnerLastname(String lastname);

    FindCreatedCycleResponse findByOwnerMailAddress(String mailAddress);


    String deleteByMailAddress(String mailAddress);


    String deleteByLastname(String lastname);


    String deleteByProfileId (int id);
}
