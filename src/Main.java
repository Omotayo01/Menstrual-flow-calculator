import controllers.CycleController;
import dtos.requests.CreateCycleProfileRequest;
import dtos.responses.FindCreatedCycleResponse;

import javax.swing.*;

public class Main {
    private static CycleController cycleController = new CycleController();

    private static FindCreatedCycleResponse profile;


    public static void main(String[] args) {
        startApp();
    }
    private static void startApp() {
        String message = """
                Hi Welcome, What would you like to do?::
                1 -> Create a profile
                2 -> Enter your created profile
                3 -> Exit
                """;
        String input = input(message);
        try { cycleController.validateMainMenuEntry(message);
        switch (input.charAt(0)) {
            case '1' -> register();
            case '2' -> login();
            case '3' -> exitApplication();
            default -> {
                display("Invalid input try again");
                startApp();
            }}}catch (IllegalArgumentException error){
                display(error.getMessage());
                startApp();
            }
        }


    private static void continueInApp() {
        String message = """
                1 -> See dates for your future monthly flows
                2 -> Enter to unveil your safe periods
                3 -> Enter to unveil ovulation dates
                4 -> Delete your Profile
                5 -> Logout
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> monthlyFlows();
            case '2' -> safePeriods();
            case '3' -> ovulation();
            case '4' -> deleteProfile();
            case '5' -> logout();
            default -> {
                display("Invalid input try again");
                continueInApp();
            }
        }
    }

    private static void logout() {

        display(" Logged out successfully");

        startApp();
    }

    private static void deleteProfile() {
        String userInput = input("Enter your lastname, we just want to be sure" +
                " it's you ");
        String userInputTwo = input("Enter your email address, we still trying to be sure" +
                " it's you ");
        try {

            profile = cycleController.findByOwnerEmailAddress(userInputTwo);
            display(cycleController.deleteProfileByOwnerLastname(userInput));
            startApp();
        } catch (IllegalArgumentException | NullPointerException e) {
            display(e.getMessage());
            continueInApp();
        }
    }

    private static void ovulation() {
        String emailAddress = input("Kindly enter your email address, we respect your privacy , we just " +
                "want to be sure it is you ");
        int numberOfMonths = Integer.parseInt(input("Ovulation date for how many calender " +
                "months do you wish to see not exceeding 12 months ? "));

        try {
            profile = cycleController.findByOwnerEmailAddress(emailAddress);

            display(String.valueOf(cycleController.ovulationDateForTwelveMonths(profile.getEmailAddress(), numberOfMonths, profile.getFirstDayOfLastFlow()
                    , profile.getCycleLength())));
            continueInApp();
        }catch (IllegalArgumentException | NullPointerException e){
            display(e.getMessage());
            continueInApp();
        }

    }

    private static void safePeriods() {
        String emailAddress = input("Kindly enter your email address, we respect your privacy , we just " +
                "want to be sure it is you ");
        int numberOfMonths = Integer.parseInt(input("Safe period dates for how many calender " +
                "months do you wish to see ? "));

        try {
            profile = cycleController.findByOwnerEmailAddress(emailAddress);

            display(String.valueOf(cycleController.safePeriodDateForTwelveMonths(profile.getEmailAddress(), numberOfMonths, profile.getFirstDayOfLastFlow()
                    , profile.getCycleLength())));
            continueInApp();
        }catch (IllegalArgumentException | NullPointerException e){
            display(e.getMessage());
            continueInApp();
        }
    }

    private static void monthlyFlows() {
        String emailAddress = input("Kindly enter your email address");
        int numberOfMonths = Integer.parseInt(input("how many months calender do you wish to see? "));

        try {
            profile = cycleController.findByOwnerEmailAddress(emailAddress);

            display(String.valueOf(cycleController.flowDateForTwelveMonths(profile.getEmailAddress(), numberOfMonths, profile.getFirstDayOfLastFlow()
                    , profile.getCycleLength())));
            continueInApp();
        }catch (IllegalArgumentException | NullPointerException e){
            display(e.getMessage());
            continueInApp();
        }
    }

    private static void register() {
        try {
            CreateCycleProfileRequest request = new CreateCycleProfileRequest();
            request.setFirstName(input("Enter first Name "));
            request.setLastName(input("Enter last Name "));
            request.setEmailAddress(input("Enter mail address of your choice "));
            request.setCycleLength(Integer.parseInt(input("what is the duration between the beginning of " +
                    "one monthly flow and the beginning of the next?")));
            request.setFirstDayOfLastFlow(input("enter the first day of ur last monthly flow in this format yyyy-MM-dd"));
            request.setPeriodDuration(Integer.parseInt(input("How many days do your flow last for?")));
            var result = cycleController.createProfile(request);
            display("Profile created successfully");
            display(result.toString());
            startApp();
        } catch (IllegalArgumentException e){
            display(e.getMessage());
            startApp();
        }
    }

    private static void login() {
        String lastname = input("Enter your lastname, just to be sure it is you, your " +
                "privacy is our utmost priority ");
        try {
            profile = cycleController.findByOwnerLastname(lastname);
            display("Your are in");
            continueInApp();
        }catch (IllegalArgumentException | NullPointerException e){
            display(e.getMessage());
            startApp();
        }
    }

    private static void exitApplication() {
        display("Thanks for using this application ");
        System.exit(1);
    }

    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static String input(String dialogue) {
        return JOptionPane.showInputDialog(dialogue);
    }
}