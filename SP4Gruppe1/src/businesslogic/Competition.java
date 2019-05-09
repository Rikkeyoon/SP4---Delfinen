package businesslogic;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class Competition {

    private String competitionName;
    private int ranking;
    private LocalTime bestTimeInCompetition;
    private LocalDate dateOfCompetition;
    private String competition;
    private CompetitiveSwimmer competitiveSwimmer;

    public Competition(CompetitiveSwimmer competitiveSwimmer, String competitionName, int ranking, LocalTime bestTimeInCompetition) {
        this.competitionName = competitionName;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
        this.competitiveSwimmer = competitiveSwimmer;
    }

    public Competition(String competitionName, LocalDate dateOfCompetition, int ranking, LocalTime bestTimeInCompetition) {
        this.competitionName = competitionName;
        this.dateOfCompetition = dateOfCompetition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(Member id, String competition, LocalDate dateOfCompetition) {
        this.competition = competition;
        this.dateOfCompetition = dateOfCompetition;
    }

    public Competition(Member member, String competition, LocalDate dateOfCompetition, int ranking, LocalTime bestTimeInCompetition) {
        member.getId();
        this.competition = competition;
        this.dateOfCompetition = dateOfCompetition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(String competition, int ranking, LocalTime bestTimeInCompetition) {
        this.competition = competition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(Member member, String competition, String dateOfCompetition, int ranking, LocalTime time) {
        member.getId();
        this.competition =competition;
        this.dateOfCompetition = LocalDate.parse(dateOfCompetition);
        this.ranking = ranking;
        this.bestTimeInCompetition = time;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public LocalTime getBestTimeInCompetition() {
        return bestTimeInCompetition;
    }

    public void setBestTimeInCompetition(LocalTime bestTimeInCompetition) {
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public LocalDate getDateOfCompetition() {
        return dateOfCompetition;
    }

    public void setDateOfCompetition(LocalDate dateOfCompetition) {
        this.dateOfCompetition = dateOfCompetition;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }
    
    public CompetitiveSwimmer getCompetitiveSwimmer() {
        return competitiveSwimmer;
    }

    public void setCompetitiveSwimmer(CompetitiveSwimmer competitiveSwimmer) {
        this.competitiveSwimmer = competitiveSwimmer;
    }

    @Override
    public String toString() {
        return "\nCompetitionName: \t" + competitionName
                + "\nRanking: \t\t" + ranking
                + "\nBestTimeInCompetition: \t\t" + bestTimeInCompetition;
    }
}
