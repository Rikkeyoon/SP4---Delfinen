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

    public String scanString();

    public boolean scanBoolean();

    public void print(String str);

    public int scanInt();

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

    public String scanDate();

    public String scanName();

    public int editMemberChoice();

    public int scanID();

    public void showEditMemberMenu();

    public void showEditContingentMenu();

    public int editContingentChoice();

    public void showCompetitiveSwimmerList(ArrayList<CompetitiveSwimmer> competitiveSwimmers);

    public void showTrainingresults(ArrayList<CompetitiveSwimmer> trainingresults);

    public void showSwimmersInCompetition(ArrayList<CompetitiveSwimmer> competitiveSwimmers);

    public void showCompetitionResults(ArrayList<Competition> competitionResults);

    public LocalTime scanTime();

    public void showEditTrainingsresultMenu();

    public int editTrainingsresultChoice();

    public void showEditCompetitionresultMenu();

    public int editCompetitionresultChoice();







    
    
}
