package businesslogic;

import java.sql.Time;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class Competition {
    
    private String competitionName;
    private int ranking;
    private Time bestTimeInCompetition;

    public Competition(CompetitiveSwimmer competitiveSwimmer, String competitionName, int ranking, Time bestTimeInCompetition) {
        this.competitionName = competitionName;
        this.ranking = ranking;
        this.bestTimeInCompetition = bestTimeInCompetition;
    }

    public Competition(String competitionName, int ranking, Time bestTimeInCompetition) {
        this.competitionName = competitionName;
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

    @Override
    public String toString() {
        return "CompetitionName: \t" + competitionName 
                + "\nRanking: \t\t" + ranking 
                + "\nBestTimeInCompetition: \t\t" + bestTimeInCompetition;
    }
}
