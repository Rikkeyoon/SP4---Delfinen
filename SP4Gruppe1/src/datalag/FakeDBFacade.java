package datalag;

import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Caroline, Nina, Rikke og Kristina
 */
public class FakeDBFacade implements DBStorage {

    private int id = 1;
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<>();
    private ArrayList<Contingent> contingentList;
    private Comparator<CompetitiveSwimmer> compareBestTime
            = (CompetitiveSwimmer o1, CompetitiveSwimmer o2) -> {
                return o1.getBestTime().compareTo(o2.getBestTime());
            };

    @Override
    public int getID() {
        return id++;
    }

    @Override
    public ArrayList<Member> getMembersList() {
        return members;
    }

    @Override
    public void saveMember(Member member) {
        members.add(member);
    }

    @Override
    public void deleteMember(int id) {
        Member member = getMemberById(id);
        members.remove(member);
    }

    @Override
    public void saveCompetitiveSwimmer(CompetitiveSwimmer member) {
        competitiveSwimmers.add(member);
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getTop5() {
        ArrayList<CompetitiveSwimmer> top5 = new ArrayList<>();
        
        Collections.sort(competitiveSwimmers, compareBestTime);
        for (int i = 0; i < 5; i++) {
            CompetitiveSwimmer swimmer = competitiveSwimmers.get(i);
            top5.add(swimmer);
        }
        return top5;
    }

    @Override
    public ArrayList<Contingent> getContingentList() {
        return contingentList;
    }

    @Override
    public ArrayList<Member> getMembersInRestance() {
        ArrayList<Member> membersInRestance = new ArrayList<>();
        for (Member member : members) {
            if (member.getRestance() != 0) {
                membersInRestance.add(member);
            }
        }
        return membersInRestance;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        return competitiveSwimmers;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getTrainingsresult() {
        Collections.sort(competitiveSwimmers, compareBestTime);
        return competitiveSwimmers;
    }

    @Override
    public int editUnder18(int contingent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editBetween18And60(int contingent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editOver60(int contingent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editPassive(int contingent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member getMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void editRestance(int id, int newRestance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editFirstName(int id, String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editLastName(int id, String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editActiveness(int id, boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionSwimmers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
