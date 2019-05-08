package datalag;

import businesslogic.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Caroline, Nina, Rikke og Kristine
 */
public class FakeDBFacade implements DBStorage {

    private int id = 1;
    private ArrayList<Member> members;
    private ArrayList<CompetitiveSwimmer> competitiveSwimmers;
    private ArrayList<Contingent> contingentList;;
    private ArrayList<CompetitiveSwimmer> swimmersInCompetition;;
    private Comparator<CompetitiveSwimmer> compareBestTime;
    private Comparator<Competition> compareCompetitionTime;

    public FakeDBFacade() {
        compareCompetitionTime = (Competition o1, Competition o2) -> {
            return o1.getBestTimeInCompetition()
                    .compareTo(o2.getBestTimeInCompetition());
        };
        compareBestTime = (CompetitiveSwimmer o1, CompetitiveSwimmer o2) -> {
            return (o1.getBestTime()).compareTo(o2.getBestTime());
        };
        
        swimmersInCompetition = new ArrayList<>();
        contingentList = new ArrayList<>();
        contingentList.add(new Contingent(1000, 1600, (int)(1600 * 0.75), 500));
        competitiveSwimmers = new ArrayList<>();
        members = new ArrayList<>();
    }

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
        for (Contingent con : contingentList) {
            con.setUnder18(contingent);
        }
        return 0;
    }

    @Override
    public int editBetween18And60(int contingent) {
        for (Contingent con : contingentList) {
            con.setBetween18And60(contingent);
        }
        return 0;
    }

    @Override
    public int editOver60(int contingent) {
        for (Contingent con : contingentList) {
            con.setOver60(contingent);
        }
        return 0;
    }

    @Override
    public int editPassive(int contingent) {
        for (Contingent con : contingentList) {
            con.setPassive(contingent);
        }
        return 0;
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
        for (Member member : members) {
            if (member.getId() == id) {
                member.setRestance(newRestance);
            }
        }
    }

    @Override
    public void editFirstName(int id, String firstName) {
        for (Member member : members) {
            if (member.getId() == id) {
                member.setFirstName(firstName);
            }
        }
    }

    @Override
    public void editLastName(int id, String lastName) {
        for (Member member : members) {
            if (member.getId() == id) {
                member.setLastName(lastName);
            }
        }
    }

    @Override
    public void editActiveness(int id, boolean active) {
        for (Member member : members) {
            if (member.getId() == id) {
                member.setIsActive(active);
            }
        }
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionSwimmers() {
        return swimmersInCompetition;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionResult() {
        /*We can't just compare the swimmers by their best time, because it
         *correlates to their trainingresults, and not their results/times 
         *in the competitions; therefore, we have to do it this way
         */
        
        //get the compititions the competitive swimmer has been in
        ArrayList<Competition> competitions = new ArrayList<>();
        for (CompetitiveSwimmer compSwimmer : swimmersInCompetition) {
            Competition competition = compSwimmer.getCompetition();
            competitions.add(competition);
        }
        //sort the list of competitions after the best times
        Collections.sort(competitions, compareCompetitionTime);
        
        /*create a temporary ArrayList, so the ArrayList returned is 
         *sorted by the best times
         */
        ArrayList<CompetitiveSwimmer> compSwimmers = new ArrayList<>();
        for (Competition competition : competitions) {
            CompetitiveSwimmer compSwimmer = competition.getCompetitiveSwimmer();
            compSwimmers.add(compSwimmer);
        }
        return compSwimmers;
    }

    @Override
    public void editDisciplin(int id, String newDisciplin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editBestTime(int id, LocalTime newBestTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editDate(int id, String newDateOfBestTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
