package presentation;

import businesslogic.Member;
import java.time.LocalDate;
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
    public void showMemberList(ArrayList<Member> members) {
        for (Member member : members) {
            System.out.println(member.toString());
        }
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
        System.out.println("Choose one of the following options: \n"
                + "1. Contingent\n"
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
                + "1. Swimmers in restance\n"
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
                + "1. Competitive swimmers\n"
                + "2. Trainingsresult\n"
                + "3. Edit trainingsresult\n"
                + "4. Back to main menu\n"
                + "0. Quit");
    }

    @Override
    public int competitiveSwimmersMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println(choice + " is not an option, try again: ");
            choice = input.nextInt();
        }
        return choice;
    }

    @Override
    public void showCompetitionMenu() {
        System.out.println("Choose one of the following options: \n"
                + "1. Swimmers in competition\n"
                + "2. Competition results\n"
                + "3. Edit results"
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
    public String scanDate() {
        String choice = input.nextLine();

        try {
            LocalDate.parse(choice);
        } catch (DateTimeParseException e) {
            boolean exceptionThrown = true;
            while (exceptionThrown) {
                System.out.println(choice + " is not an option, try again: ");
                choice = input.nextLine();
                exceptionThrown = false;
            }
        }
        return choice;
    }

    @Override
    public int editMemberChoice() {
        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
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
    public void showEditMemberMenu() {
        System.out.println("Press 1 to edit first name\n"
                + "Press 2 to edit last name\n"
                + "Press 3 to edit activeness\n"
                + "Press 4 to return");
    }
    

}
