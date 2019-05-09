package datalag;

import businesslogic.Competition;
import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public interface DBStorage {

    public int getID();

    public ArrayList<Member> getMembersList();

    public void saveMember(Member member);

    public void deleteMember(int id);

    public void saveCompetitiveSwimmer(CompetitiveSwimmer member);

    public ArrayList<CompetitiveSwimmer> getTop5();

    public ArrayList<Contingent> getContingentList();

    public ArrayList<Member> getMembersInRestance();

    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers();

    public ArrayList<CompetitiveSwimmer> getTrainingsresult();

    public int editUnder18(int contingent);

    public int editBetween18And60(int contingent);

    public int editOver60(int contingent);

    public int editPassive(int contingent);

    public Member getMemberById(int id);
    
    public void editRestance(int id, int newRestance);
    
    public void editFirstName(int id, String firstName);
    
    public void editLastName(int id, String lastName);
    
    public void editActiveness(int id, boolean active);
    
    public ArrayList<CompetitiveSwimmer> getCompetitionSwimmers();
    
    public ArrayList<Competition> getCompetitionResult();

    public void editDisciplin(int id, String newDisciplin);

    public void editBestTime(int id, LocalTime newBestTime);

    public void editDate(int id, String newDateOfBestTime);

    public Member getCompetitiveSwimmerbyID(int compSwimID);

    public void saveCompetition(Competition comp, Member id);

    public void editRanking(int id, int newRanking);

    public void editCompetitionName(int id, String newCompetitionName);
    
    

}
