package presentation;

import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.util.ArrayList;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class FakeUI implements UI {

    String[] input;
    int index = 0;
    public ArrayList<String> output = new ArrayList<>();

    public FakeUI(String[] input) {
        this.input = input;
    }

    @Override
    public String scanString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean scanBoolean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int scanInt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMemberList(ArrayList<Member> members) {
        for (Member member : members) {
            output.add(member.toString());
        }
    }

    @Override
    public void showMainMenu() {
        output.add("-------------------------\n"
                + "SVØMMEKLUBBEN - DELFINEN\n"
                + "-------------------------\n"
                + "Choose one of the following options: \n"
                + "1. Members\n"
                + "2. Contingent\n"
                + "3. Restance\n"
                + "4. Top 5 swimmers\n"
                + "5. Competitive swimmers\n"
                + "6. Competition\n"
                + "0. Quit");
    }

    @Override
    public int mainMenuChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showMembersMenu() {
        output.add("Choose one of the following options: \n"
                + "1. List of members\n"
                + "2. Add member\n"
                + "3. Edit members\n"
                + "4. Delete member\n"
                + "5. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int memberMenuChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showContingentMenu() {
        output.add("Choose one of the following options: \n"
                + "1. Contingent\n"
                + "2. Edit contingent\n"
                + "3. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int contingentMenuChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showRestanceMenu() {
        output.add("Choose one of the following options: \n"
                + "1. Swimmers in restance\n"
                + "2. Edit restance\n"
                + "3. back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int restanceMenuChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showCompetitiveSwimmersMenu() {
        output.add("Choose one of the following options: \n"
                + "1. Competitive swimmers\n"
                + "2. Trainingsresult\n"
                + "3. Edit trainingsresult\n"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int competitiveSwimmersMenuChoice() {
         return Integer.parseInt(input[index++]);
    }

    @Override
    public void showCompetitionMenu() {
        output.add("Choose one of the following options: \n"
                + "1. Swimmers in competition\n"
                + "2. Competition results\n"
                + "3. Edit results"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int competitionMenuChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showTop5(ArrayList<CompetitiveSwimmer> competitiveSwimmer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showContingentList(ArrayList<Contingent> contingent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  
    public String scanDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editMemberChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int scanID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showEditMemberMenu() {
        output.add("Press 1 to edit first name\n"
                + "Press 2 to edit last name\n"
                + "Press 3 to edit activeness\n"
                + "Press 4 to return");
    }

    @Override
    public void showEditContingentMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editContingentChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showCompetitiveSwimmerList(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
