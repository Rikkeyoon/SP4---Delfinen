package businesslogic;

import java.sql.Time;
import java.sql.Date;

 /*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class CompetitiveSwimmer extends Member {
    
    private String disciplin;
    private Time bestTime;
    private Date dateOfBestTime;
    private Competition competition;
    private Date dateOfCompetition;
    
    public CompetitiveSwimmer(String firstName, String lastName, 
            String dateOfBirth, boolean isActive, int id, String disciplin,
            Time bestTime, Date dateOfBestTime) {
        super(firstName, lastName, dateOfBirth, isActive, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
    }
    
    public CompetitiveSwimmer(String firstName, String lastName, int age, int id, 
            String disciplin, Time bestTime, Date dateOfBestTime) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
    }
    
    public CompetitiveSwimmer(String disciplin, Time bestTime, Date dateOfBestTime, 
            Competition competition, String firstName, String lastName, int age, int id) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
        this.competition = competition;
    }

    public CompetitiveSwimmer(int id, Competition comp, String firstName, String lastName, int age) {
        super(firstName, lastName, age, id);
        this.competition = comp;
    }

    public CompetitiveSwimmer(Member member, Competition comp) {
        super(member.getId());
        this.competition = comp;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public Time getBestTime() {
        return bestTime;
    }

    public void setBestTime(Time bestTime) {
        this.bestTime = bestTime;
    }

    public Date getDateOfBestTime() {
        return dateOfBestTime;
    }

    public void setDateOfBestTime(Date dateOfBestTime) {
        this.dateOfBestTime = dateOfBestTime;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Date getDateOfCompetition() {
        return dateOfCompetition;
    }

    public void setDateOfCompetition(Date dateOfCompetition) {
        this.dateOfCompetition = dateOfCompetition;
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() 
                + "\nDisciplin: " + disciplin 
                + "\nBest Time: " + bestTime 
                + "\nDate of best time: " + dateOfBestTime;
    }

    
    
}
