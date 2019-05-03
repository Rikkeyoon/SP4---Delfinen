package presentation;

import businesslogic.Member;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Caroline, Rikke & Nina
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
        System.out.println("Choose one of the following options: \n"
                + "1. Members\n"
                + "2. Contingent\n"
                + "3. Restance\n"
                + "4. Top 5 swimmers\n"
                + "5. Competition swimmers\n"
                + "6. Trainingsreusults"
                + "0. ");
    }

    @Override
    public int mainMenuChoice() {
        int choice = input.nextInt();
        while (choice < 0 || choice > 2) {
            System.out.println(choice + " er ikke en mulighed, prøv igen: ");
            choice = input.nextInt();
        }

        return choice;
    }
    
}
