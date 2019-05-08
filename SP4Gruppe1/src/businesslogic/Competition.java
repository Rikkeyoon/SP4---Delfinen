package businesslogic;

import java.sql.Date;
import java.sql.Time;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class Competition {

    private String competitionName;
    private int ranking;
    private Time bestTimeInCompetition;
    private Date dateOfCompetition;
    private String competition;

    public Competition(CompetitiveSwimmer competitiveSwimmer, String competitionName, int ranking, Time bestTimeInCompetition) {
        this.competitionName = competitionName;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(String competitionName, Date dateOfCompetition, int ranking, Time bestTimeInCompetition) {
        this.competitionName = competitionName;
        this.dateOfCompetition = dateOfCompetition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(Member id, String competition, Date dateOfCompetition) {
        this.competition = competition;
        this.dateOfCompetition = dateOfCompetition;
    }

    public Competition(Member member, String competition, String dateOfCompetition, int ranking, String bestTimeInCompetition) {
        member.getId();
        this.competition = competition;
        this.dateOfCompetition = dateOfCompetition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(String competition, int ranking, Time bestTimeInCompetition) {
        this.competition = competition;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
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

    public Time getBestTimeInCompetition() {
        return bestTimeInCompetition;
    }

    public void setBestTimeInCompetition(Time bestTimeInCompetition) {
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Date getDateOfCompetition() {
        return dateOfCompetition;
    }

    public void setDateOfCompetition(Date dateOfCompetition) {
        this.dateOfCompetition = dateOfCompetition;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "CompetitionName: \t" + competitionName
                + "\nRanking: \t\t" + ranking
                + "\nBestTimeInCompetition: \t\t" + bestTimeInCompetition;
    }
}
