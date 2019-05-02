package businesslogic;

/*
 * @author Caroline, Rikke & Nina
 */
public class Member {

    private String firstName;
    private String lastName;
    private int age;
    private String ssn;
    private int phoneNo;
    private boolean isActive;
    private double contingent;
    private double restance;

    public Member(String firstName, String lastName, int age, String ssn, int phoneNo, boolean isActive, double contingent, double restance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.phoneNo = phoneNo;
        this.isActive = isActive;
        this.contingent = contingent;
        this.restance = restance;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                + "\nage: \t" + age
                + "\nssn: \t" + ssn 
                + "\nphoneNo: \t" + phoneNo 
                + "\nstatus: \t" + isActive 
                + "\ncontingent: \t" + contingent 
                + "\nrestance: \t" + restance;
    }
}
