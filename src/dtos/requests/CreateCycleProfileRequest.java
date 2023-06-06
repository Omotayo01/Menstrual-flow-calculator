package dtos.requests;

public class CreateCycleProfileRequest {

    String firstName;

    String lastName;

    String firstDayOfLastFlow;

    int cycleLength;

    int periodDuration;

    String emailAddress;

    @Override
    public String toString() {
        return "CreateCycleProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstDayOfLastFlow='" + firstDayOfLastFlow + '\'' +
                ", cycleLength=" + cycleLength +
                ", periodDuration=" + periodDuration +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstDayOfLastFlow() {
        return firstDayOfLastFlow;
    }

    public void setFirstDayOfLastFlow(String firstDayOfLastFlow) {
        this.firstDayOfLastFlow = firstDayOfLastFlow;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public int getPeriodDuration() {
        return periodDuration;
    }

    public void setPeriodDuration(int periodDuration) {
        this.periodDuration = periodDuration;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
