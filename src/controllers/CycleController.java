package controllers;

import dtos.requests.CreateCycleProfileRequest;
import dtos.responses.FindCreatedCycleResponse;
import services.CycleService;
import services.CycleServiceImpl;

import java.util.List;


public class CycleController {

    private CycleService cycleService = new CycleServiceImpl();

    public Object createProfile(CreateCycleProfileRequest request) {
        try {
            return (cycleService.createProfile(request));
        } catch (IllegalArgumentException ex){
            return (ex.getMessage());
        }
    }

    public FindCreatedCycleResponse findByCycleId(int id) {
        return cycleService.findByProfileId(id);
    }


    public List<String> flowDateForTwelveMonths(String mailAddress, int numberOfMonths, String dateOfLastPeriod,
                                        int lengthOfCycle){
        return cycleService.calculateFlowDateForTwelveMonths(mailAddress, numberOfMonths, dateOfLastPeriod,
                lengthOfCycle);
    }

    public List<String> ovulationDateForTwelveMonths(String mailAddress, int numberOfMonths,String dateOfLastPeriod,
                                        int lengthOfCycle){
         return cycleService.calculateOvulationDateForTwelveMonths(mailAddress, numberOfMonths, dateOfLastPeriod,
                lengthOfCycle);
    }

    public List<String> safePeriodDateForTwelveMonths(String mailAddress, int numberOfMonths,String dateOfLastPeriod,
                                        int lengthOfCycle){
        return cycleService.calculateSafePeriodDateForTwelveMonths(mailAddress, numberOfMonths, dateOfLastPeriod,
                lengthOfCycle);
    }

    public String deleteProfileByCycleId(int id){
        try{
            return cycleService.deleteByProfileId(id);
        } catch (IllegalArgumentException | NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public String deleteProfileByOwnerMailAddress(String mailAddress){
        try{
            return cycleService.deleteByMailAddress(mailAddress);
        } catch (IllegalArgumentException | NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public String deleteProfileByOwnerLastname(String lastname){
        try{
            return cycleService.deleteByLastname(lastname);
        } catch (IllegalArgumentException | NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public FindCreatedCycleResponse findByOwnerEmailAddress(String mailAddress ) {
        return cycleService.findByOwnerMailAddress(mailAddress);
    }

    public FindCreatedCycleResponse findByOwnerLastname(String lastname ) {
        return cycleService.findByOwnerLastname(lastname);
    }

    public void validateMainMenuEntry(String input){
        if (input.equals(""))
            throw new IllegalArgumentException("Invalid input");
    }
}
