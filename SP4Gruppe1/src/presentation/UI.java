package presentation;

import businesslogic.Competition;
import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public interface UI {

    public void print(String str);

    public String scanString();

    public int scanInt();

    public boolean scanBoolean();

    public int scanID();

    public String scanDate();

    public String scanName();

    public LocalTime scanTime();

    public void showMemberList(ArrayList<Member> members);

    public void showMainMenu();

    public int mainMenuChoice();

    public void showMembersMenu();

    public int memberMenuChoice();

    public void showContingentMenu();

    public void showRestanceMenu();

    public void showCompetitiveSwimmersMenu();

    public void showCompetitionMenu();

    public int contingentMenuChoice();

    public int restanceMenuChoice();

    public int competitiveSwimmersMenuChoice();

    public int competitionMenuChoice();

    public void showTop5(ArrayList<CompetitiveSwimmer> competitiveSwimmer);

    public void showContingentList(ArrayList<Contingent> contingent);

    public int editMemberChoice();

    public void showEditMemberMenu();

    public void showEditContingentMenu();

    public int editContingentChoice();

    public void showCompetitiveSwimmerList(ArrayList<CompetitiveSwimmer> competitiveSwimmers);

    public void showTrainingresults(ArrayList<CompetitiveSwimmer> trainingresults);

    public void showSwimmersInCompetition(ArrayList<CompetitiveSwimmer> competitiveSwimmers);

    public void showCompetitionResults(ArrayList<Competition> competitionResults);

    public void showEditTrainingsresultMenu();

    public int editTrainingsresultChoice();

}
