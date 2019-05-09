package businesslogic;

import java.time.LocalDate;
import java.time.LocalTime;

 /*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class CompetitiveSwimmer extends Member {
    
    private String disciplin;
    private LocalTime bestTime;
    private LocalDate dateOfBestTime;
    private Competition competition;
    
    public CompetitiveSwimmer(String firstName, String lastName, 
            String dateOfBirth, boolean isActive, int id, String disciplin,
            LocalTime bestTime, String dateOfBestTime) {
        super(firstName, lastName, dateOfBirth, isActive, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = LocalDate.parse(dateOfBestTime);
    }
    
    public CompetitiveSwimmer(String firstName, String lastName, int age, int id, 
            String disciplin, LocalTime bestTime, LocalDate dateOfBestTime) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = dateOfBestTime;
    }
    
    public CompetitiveSwimmer(String disciplin, LocalTime bestTime, String dateOfBestTime, 
            Competition competition, String firstName, String lastName, int age, int id) {
        super(firstName, lastName, age, id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = LocalDate.parse(dateOfBestTime);
        this.competition = competition;
    }
    
    public CompetitiveSwimmer(int id, String disciplin,
            LocalTime bestTime, String dateOfBestTime) {
        super(id);
        this.disciplin = disciplin;
        this.bestTime = bestTime;
        this.dateOfBestTime = LocalDate.parse(dateOfBestTime);
    }


    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public void setBestTime(LocalTime bestTime) {
        this.bestTime = bestTime;
    }

    public LocalDate getDateOfBestTime() {
        return dateOfBestTime;
    }

    public void setDateOfBestTime(LocalDate dateOfBestTime) {
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
        return "\n" + super.getFirstName() + " " + super.getLastName()
                + "\nID: " + super.getId()
                + "\nDisciplin: " + disciplin 
                + "\nBest Time: " + bestTime 
                + "\nDate of best time: " + dateOfBestTime;
    }
    
}
