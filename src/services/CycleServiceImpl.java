package services;

import data.models.Cycle;
import data.repositories.CycleRepository;
import data.repositories.CycleRepositoryImpl;
import dtos.requests.CreateCycleProfileRequest;
import dtos.responses.FindCreatedCycleResponse;
import utils.Mapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CycleServiceImpl implements CycleService{

    private static CycleRepository cycleRepository = new CycleRepositoryImpl();


    @Override
    public Cycle createProfile(CreateCycleProfileRequest request) {
        if (userExist(request.getEmailAddress()) == true) throw new IllegalArgumentException
                (request.getEmailAddress() + " is already taken by a user, Kindly think about another mail address");
        return cycleRepository.createProfile(Mapper.map(request));
    }

    private boolean userExist(String emailAddress) {

        Cycle found = cycleRepository.findCycleByOwnerEmailAddress(emailAddress);
        if (found != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> calculateFlowDateForTwelveMonths(String mailAddress, int numberOfMonths,
                                                        String dateOfLastPeriod, int lengthOfCycle) {
        Cycle foundProfile = cycleRepository.findCycleByOwnerEmailAddress(mailAddress);
        if (foundProfile == null) throw new NullPointerException("Profile does not exist");

        List<String> output = new ArrayList<>();

        LocalDate input = LocalDate.parse(dateOfLastPeriod);
        int count = 1;

        for (int i = 0; i <= 12; i++){
            if (i == numberOfMonths){
                break;
            }
            LocalDate result = input.plusDays(lengthOfCycle * count);
            output.add("your menstruation " + count + " month after the one you saw on " + dateOfLastPeriod
                    + " will arrive on " + result);
            count++;
        }
        return output;
    }

    @Override
    public List<String> calculateOvulationDateForTwelveMonths(String mailAddress, int numberOfMonths,
                                                      String dateOfLastPeriod, int lengthOfCycle) {
        Cycle foundProfile = cycleRepository.findCycleByOwnerEmailAddress(mailAddress);
        if (foundProfile == null) throw new NullPointerException("User does not exist");

        List<String> output = new ArrayList<>();

        LocalDate input = LocalDate.parse(dateOfLastPeriod);
        int count = 1;

        for (int i = 0; i <= 12; i++){
            if (i == numberOfMonths){
                break;

            }
            LocalDate result = input.plusDays((lengthOfCycle * count) - 14);
            output.add("your next " + count + " ovulation will be on " + result );
            count++;
        }
        return output;
    }

    @Override
    public List<String> calculateSafePeriodDateForTwelveMonths(String mailAddress, int numberOfMonths, String dateOfLastPeriod, int lengthOfCycle){
        Cycle foundProfile = cycleRepository.findCycleByOwnerEmailAddress(mailAddress);
        if (foundProfile == null) throw new NullPointerException("User does not exist");

        List<String> output = new ArrayList<>();

        LocalDate input = LocalDate.parse(dateOfLastPeriod);
        int count = 1;

        for (int i = 0; i <= 12; i++){
            if (i == numberOfMonths){
                break;

            }
            LocalDate result = input.plusDays((lengthOfCycle * count));
            output.add("your safe period for the  next " + count + " month is between " + result +
                    " ---- " + result.minusDays(19) + " and " + result.minusDays(12) +
                    " ---- " + result.minusDays(1));
            count++;
        }
        return output;
    }

    @Override
    public FindCreatedCycleResponse findByProfileId(int id) {
        Cycle foundCycle = cycleRepository.findCycleByCycleId(id);
        if (foundCycle == null) throw new NullPointerException("Profile does not exist or have been deleted ");
        FindCreatedCycleResponse response = new FindCreatedCycleResponse();
        Mapper.map(foundCycle, response);
        return response;
    }

    @Override
    public FindCreatedCycleResponse findByOwnerLastname(String lastname) {
        Cycle foundCycle = cycleRepository.findCycleByOwnerLastname(lastname);
        if (foundCycle == null) throw new NullPointerException("Profile does not exist or have been deleted ");
        FindCreatedCycleResponse response = new FindCreatedCycleResponse();
        Mapper.map(foundCycle, response);
        return response;
    }

    @Override
    public FindCreatedCycleResponse findByOwnerMailAddress(String mailAddress) {
        Cycle foundCycle = cycleRepository.findCycleByOwnerEmailAddress(mailAddress);
        if (foundCycle == null) throw new NullPointerException("Profile does not exist or have been deleted ");
        FindCreatedCycleResponse response = new FindCreatedCycleResponse();
        Mapper.map(foundCycle, response);
        return response;
    }

    @Override
    public String deleteByMailAddress(String mailAddress) {
        Cycle foundProfile = cycleRepository.findCycleByOwnerEmailAddress(mailAddress);
        if (foundProfile == null) throw new NullPointerException("Profile does not exist or have been deleted");
        cycleRepository.deleteByOwnerEmailAddress(mailAddress);
        return "Profile successfully deleted, your privacy is our priority";
    }

    @Override
    public String deleteByLastname(String lastname) {
        Cycle foundProfile = cycleRepository.findCycleByOwnerLastname(lastname);
        if (foundProfile == null) throw new NullPointerException("Profile does not exist or have been deleted");
        cycleRepository.deleteByOwnerLastname(lastname);
        return "Profile successfully deleted, your privacy is our priority";
    }

    @Override
    public String deleteByProfileId(int id) {
        Cycle foundProfile = cycleRepository.findCycleByCycleId(id);
        if (foundProfile == null) throw new NullPointerException("Profile does not exist or have been deleted");
        cycleRepository.deleteByCycleId(id);
        return "Profile successfully deleted, your privacy is our priority";
    }



}
