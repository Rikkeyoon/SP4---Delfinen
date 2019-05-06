package businesslogic;

import java.time.LocalDate;
import java.time.Period;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class Member {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dateOfBirth;
    private int id;
    private boolean isActive;
    private double contingent;
    private double restance;

    public Member(String firstName, String lastName, 
            String dateOfBirth, boolean isActive, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.isActive = isActive;
        this.id = id;
        restance = 0;
        contingent = calculateContingent();
        age = calculateAge();
    }
    
    public Member(String firstName, String lastName, int age, 
            boolean isActive, int contingent, int restance, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isActive = isActive;
        this.contingent = contingent;
        this.restance = restance;
        this.id = id;
    }
    
    public Member(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return firstName + " " + lastName
                + "\nAge: \t\t" + age + " y/o"
                + "\nStatus: \t" + isActive
                + "\nContingent: \t" + contingent + " DKK"
                + "\nRestance: \t" + restance + " DKK\n";
    }
}
