package businesslogic;

import java.util.Date;

/*
 * @author Caroline, Rikke & Nina
 */
public class Member {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String ssn;
    private int phoneNo;
    private boolean isActive;
    private double contingent;
    private double restance;

    public Member(String firstName, String lastName, Date dateOfBirth, String ssn, int phoneNo, boolean isActive, double restance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.phoneNo = phoneNo;
        this.isActive = isActive;
        this.restance = restance;
        contingent = calculateContingent();
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    @Override
    public String toString() {
        return "Member:\t\t" + firstName + " "+ lastName 
                + "\nage: \t" + dateOfBirth
                + "\nssn: \t" + ssn 
                + "\nphoneNo: \t" + phoneNo 
                + "\nstatus: \t" + isActive 
                + "\ncontingent: \t" + contingent 
                + "\nrestance: \t" + restance;
    }

    private double calculateContingent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
