package businesslogic;

import java.sql.Time;
import java.sql.Timestamp;

 /*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class CompetitiveSwimmer extends Member {
    
    private String disciplin;
    private Time bestTime;
    private Timestamp dateOfBestTime;
    private Competition competition;
    
    public CompetitiveSwimmer(String firstName, String lastName, 
            String dateOfBirth, boolean isActive, int id, String disciplin,
            Time bestTime, Timestamp dateOfBestTime) {
        super(firstName, lastName, dateOfBirth, isActive, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
    }
    
    public CompetitiveSwimmer(String firstName, String lastName, int age, int id, 
            String disciplin, Time bestTime, Timestamp dateOfBestTime) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
    }
    
    public CompetitiveSwimmer(String disciplin, Time bestTime, Timestamp dateOfBestTime, 
            Competition competition, String firstName, String lastName, int age, int id) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
        this.competition = competition;
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

    public Timestamp getDateOfBestTime() {
        return dateOfBestTime;
    }

    public void setDateOfBestTime(Timestamp dateOfBestTime) {
        this.dateOfBestTime = dateOfBestTime;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    
    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() 
                + "\nDisciplin: " + disciplin 
                + "\nBest Time: " + bestTime 
                + "\nDate of best time: " + dateOfBestTime;
    }
    
}
