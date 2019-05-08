package presentation;

import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class FakeUI implements UI {

    String[] input;
    int index = 1;
    public ArrayList<String> output = new ArrayList<>();

    public FakeUI(String[] input) {
        this.input = input;
    }

    @Override
    public String scanString() {
        return input[index++];
    }

    @Override
    public boolean scanBoolean() {
        return input[index++].contains("y");
    }

    @Override
    public void print(String str) {
        output.add(str);
    }

    @Override
    public int scanInt() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showMemberList(ArrayList<Member> members) {
        StringBuilder strBuild = new StringBuilder();
        for (Member member : members) {
            strBuild.append(member.toString());
        }
        output.add(strBuild.toString());
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
    public void showTop5(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        StringBuilder strBuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitiveSwimmers) {
            strBuild.append(compSwimmer.toString());
        }
        output.add(strBuild.toString());
    }

    @Override
    public void showContingentList(ArrayList<Contingent> contingent) {
        StringBuilder strBuild = new StringBuilder();
        for (Contingent cont : contingent) {
            strBuild.append(cont.toString());
        }
        output.add(strBuild.toString());
    }

    @Override
    public String scanDate() {
        return input[index++];
    }

    @Override
    public String scanName() {
        return input[index++];
    }

    @Override
    public int editMemberChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public int scanID() {
        return Integer.parseInt(input[index++]);
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
        output.add("Choose one of the following options: \n"
                + "1. Contingent\n"
                + "2. Edit contingent\n"
                + "3. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int editContingentChoice() {
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void showCompetitiveSwimmerList(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        StringBuilder strBuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitiveSwimmers) {
            strBuild.append(compSwimmer.toString());
        }
        output.add(strBuild.toString());
    }

    @Override
    public void showTrainingresults(ArrayList<CompetitiveSwimmer> trainingresults) {
        StringBuilder strBuild = new StringBuilder();
        for (CompetitiveSwimmer trainingresult : trainingresults) {
            strBuild.append(trainingresult);
        }
        output.add(strBuild.toString());
    }

    @Override
    public void showSwimmersInCompetition(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        StringBuilder strBuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitiveSwimmers) {
            strBuild.append(compSwimmer);
        }
        output.add(strBuild.toString());
    }

    @Override
    public void showCompetitionResults(ArrayList<CompetitiveSwimmer> competitionResults) {
        StringBuilder strBuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitionResults) {
            strBuild.append(compSwimmer);
        }
        output.add(strBuild.toString());
    }

    @Override
    public LocalTime scanTime() {
        String choice = input[index++];
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = choice;
        return LocalTime.parse(time, dft);
    }

    @Override
    public void showEditTrainingsresultMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editTrainingsresultChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 
}
