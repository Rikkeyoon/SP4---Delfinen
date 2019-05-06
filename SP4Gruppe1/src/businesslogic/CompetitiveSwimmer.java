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

    @Override
    public String toString() {
        return 
                "CompetitiveSwimmer{" + "disciplin=" + disciplin + ", bestTime=" + bestTime + ", dateOfBestTime=" + dateOfBestTime + '}';
    }

    
    
}
