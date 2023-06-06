package data.models;

public class Cycle {

    private String firstName;

    private String lastName;

    private String dateBefore;

    private int cycleLength;

    private int periodDuration;

    private int cycleId;

    private String emailAddress;

    @Override
    public String toString() {
        return "Cycle{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBefore='" + dateBefore + '\'' +
                ", cycleLength=" + cycleLength +
                ", periodDuration=" + periodDuration +
                ", cycleId=" + cycleId +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public int getCycleId() {
        return cycleId;
    }

    public void setCycleId(int cycleId) {
        this.cycleId = cycleId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getDateBefore() {
        return dateBefore;
    }

    public void setDateBefore(String dateBefore) {
        this.dateBefore = dateBefore;
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
}
