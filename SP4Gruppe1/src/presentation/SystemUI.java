package presentation;

import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class SystemUI implements UI {

    private Scanner input = new Scanner(System.in);

    @Override
    public String scanString() {
        return input.nextLine();
    }

    @Override
    public boolean scanBoolean() {
        String answer = input.nextLine();
        while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
            System.out.println("Invalid input, please try again: ");
            answer = input.nextLine();
        }
        return answer.equalsIgnoreCase("y");
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public int scanInt() {
        return input.nextInt();
    }

    @Override
    public String scanDate() {
        String choice = input.nextLine();
        while (choice.isEmpty()) {
            System.out.println("Please enter a date: ");
            choice = input.nextLine();
        }

        try {
            LocalDate.parse(choice);
        } catch (DateTimeParseException e) {
            boolean exceptionCaught = true;

            while (exceptionCaught) {
                System.out.println(choice + " is not an option, try again: ");
                exceptionCaught = false;
                choice = scanDate();
            }
        }
        return choice;
    }

    @Override
    public LocalTime scanTime() {
        String choice = input.nextLine();
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = choice;
        return LocalTime.parse(time, dft);
    }

    @Override
    public void showMemberList(ArrayList<Member> members) {
        StringBuilder strbuild = new StringBuilder();
        for (Member member : members) {
            strbuild.append(member.toString());
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showMainMenu() {
        System.out.println("-------------------------\n"
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
        int choice = input.nextInt();
        while (choice < 0 || choice > 6) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showMembersMenu() {
        System.out.println("Choose one of the following options: \n"
                + "1. List of members\n"
                + "2. Add member\n"
                + "3. Edit members\n"
                + "4. Delete member\n"
                + "5. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int memberMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 5) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showContingentMenu() {
        System.out.println("\nChoose one of the following options: \n"
                + "1. Contingent prices\n"
                + "2. Edit contingent\n"
                + "3. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int contingentMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showRestanceMenu() {
        System.out.println("Choose one of the following options: \n"
                + "1. List of swimmers in restance\n"
                + "2. Edit restance\n"
                + "3. back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int restanceMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showCompetitiveSwimmersMenu() {
        System.out.println("Choose one of the following options: \n"
                + "1. List of competitive swimmers\n"
                + "2. Create competitive swimmer\n"
                + "3. Edit trainingsresult\n"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int competitiveSwimmersMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 5) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showCompetitionMenu() {
        System.out.println("Choose one of the following options: \n"
                + "1. List of swimmers in competition\n"
                + "2. Competition results\n"
                + "3. Edit results\n"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int competitionMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public String scanName() {
        String choice = input.nextLine();
        for (char c : choice.toCharArray()) {
            while (!Character.isAlphabetic(c)) {
                System.out.println("Invalid name, please try again");
                choice = input.nextLine();
            }
        }
        return choice;
    }

    @Override
    public void showEditMemberMenu() {
        System.out.println("What would you like to edit?\n"
                + "1. First name\n"
                + "2. Last name\n"
                + "3. Activeness\n"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int editMemberChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public int scanID() {
        return input.nextInt();
    }

    @Override
    public void showTop5(ArrayList<CompetitiveSwimmer> competitiveSwimmer) {
        StringBuilder strbuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitiveSwimmer) {
            strbuild.append(compSwimmer);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showContingentList(ArrayList<Contingent> contingent) {
        StringBuilder strbuild = new StringBuilder();
        for (Contingent cont : contingent) {
            strbuild.append(cont);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showEditContingentMenu() {
        System.out.println("\nWhat would you like to change?\n"
                + "1. Under 18\n"
                + "2. Between 18 and 60\n"
                + "3. Over 60\n"
                + "4. Passive\n"
                + "5. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int editContingentChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 5) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showCompetitiveSwimmerList(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        StringBuilder strbuild = new StringBuilder();
        for (CompetitiveSwimmer compSwimmer : competitiveSwimmers) {
            strbuild.append(compSwimmer);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showTrainingresults(ArrayList<CompetitiveSwimmer> trainingresults) {
        StringBuilder strbuild = new StringBuilder();
        for (CompetitiveSwimmer trainingresult : trainingresults) {
            strbuild.append(trainingresult);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showSwimmersInCompetition(ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        StringBuilder strbuild = new StringBuilder();
        for (CompetitiveSwimmer competitiveSwimmer : competitiveSwimmers) {
            strbuild.append(competitiveSwimmer);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showCompetitionResults(ArrayList<CompetitiveSwimmer> competitionResults) {
        StringBuilder strbuild = new StringBuilder();
        for (CompetitiveSwimmer competitionResult : competitionResults) {
            strbuild.append(competitionResult);
        }
        System.out.println(strbuild.toString());
    }

    @Override
    public void showEditTrainingsresultMenu() {
        System.out.println("What would you like to edit?\n"
                + "\n1. Disciplin"
                + "\n2. Best time"
                + "\n3. Date of best time"
                + "\n4. Back to main menu"
                + "\n0. Quit");
    }

    @Override
    public int editTrainingsresultChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

}
