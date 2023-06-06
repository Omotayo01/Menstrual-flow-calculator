package services;

import org.junit.jupiter.api.Test;

import java.text.ParseException;


class CycleServiceImplTest {

    @Test

    public void testAFunctionality() {

        CycleServiceImpl cycle = new CycleServiceImpl();

        cycle.calculateFlowDateForTwelveMonths("dgh", 4, "2023-11-16",
                28);
    }

    @Test

    public void testAnotherFunctionality() {

        CycleServiceImpl cycle = new CycleServiceImpl();

        cycle.calculateOvulationDateForTwelveMonths("dgh", 4, "2023-11-16",
                28);
    }

    @Test

    public void testThirdFunctionality() {

        CycleServiceImpl cycle = new CycleServiceImpl();

        cycle.calculateSafePeriodDateForTwelveMonths("dgh", 4, "2023-11-16",
                28);
    }
}