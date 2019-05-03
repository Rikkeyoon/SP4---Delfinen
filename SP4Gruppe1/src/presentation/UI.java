package presentation;

import businesslogic.Member;
import java.util.ArrayList;

/*
 * @author Caroline, Rikke & Nina
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
    
    
}
