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
    
}
