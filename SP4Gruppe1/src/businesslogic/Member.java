package businesslogic;

import java.time.LocalDate;
import java.time.Period;

/*
 * @author Caroline, Rikke & Nina
 */
public class Member {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dateOfBirth;
    private String ssn;
    private int phoneNo;
    private boolean isActive;
    private double contingent;
    private double restance;

    public Member(String firstName, String lastName, String dateOfBirth, String ssn, int phoneNo, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.ssn = ssn;
        this.phoneNo = phoneNo;
        this.isActive = isActive;
        restance = 0;
        contingent = calculateContingent();
        age = calculateAge();
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getContingent() {
        return contingent;
    }

    public void setContingent(double contingent) {
        this.contingent = contingent;
    }

    public double getRestance() {
        return restance;
    }

    public void setRestance(double restance) {
        this.restance = restance;
    }
    
    public int getAge() {
        return age;
    }
    
    private int calculateAge() {
         // Get today
        LocalDate today = LocalDate.now();
        
        //Compare birthday - today in years (= age)
        Period period = Period.between(dateOfBirth, today);
        age = period.getYears();
        return age;
    }
    
    @Override
    public String toString() {
        return "Member:\t\t" + firstName + " " + lastName
                + "\nage: \t" + dateOfBirth
                + "\nssn: \t" + ssn
                + "\nphoneNo: \t" + phoneNo
                + "\nstatus: \t" + isActive
                + "\ncontingent: \t" + contingent
                + "\nrestance: \t" + restance;
    }

    private double calculateContingent() {
        if (isActive) {
            if (age < 60) {
                if (age < 18) {
                    return 1000;
                }
                return 1600;
            } else {
                return 1600 * 0.75;
            }
        }
        return 500;
    }

    
}
