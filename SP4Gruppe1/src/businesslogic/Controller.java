package businesslogic;

import datalag.DBFacade;
import java.util.ArrayList;
import presentation.UI;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class Controller {

    private UI ui;
    private DBFacade db;

    public Controller(UI ui, DBFacade db) {
        this.ui = ui;
        this.db = db;
    }

    public void start() {
        boolean quit = false;
        ui.showMainMenu();

        do {
            switch (ui.mainMenuChoice()) {
                case 1:
                    ui.showMembersMenu();
                    do {
                        switch (ui.memberMenuChoice()) {
                            case 1:
                                showMembersList();
                                break;
                            case 2:
                                createMember();
                                break;
                            case 3:
                                editMember();
                                break;
                            case 4:
                                deleteMember();
                                break;
                            case 5:
                                quit = true;
                                start();
                                break;
                            case 0:
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case 2:
                    ui.showContingentMenu();
                    do {
                        switch (ui.contingentMenuChoice()) {
                            case 1:
                                showContingent();
                                break;
                            case 2:
                                editContingent();
                                break;
                            case 3:
                                quit = true;
                                start();
                                break;
                            case 0:
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case 3:
                    ui.showRestanceMenu();
                    do {
                        switch (ui.restanceMenuChoice()) {
                            case 1:
                                showSwimmersInRestance();
                                break;
                            case 2:
                                editRestance();
                                break;
                            case 3:
                                quit = true;
                                start();
                                break;
                            case 0:
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case 4:
                    showTop5Swimmers();
                    break;
                case 5:
                    ui.showCompetitiveSwimmersMenu();
                    do {
                        switch (ui.competitiveSwimmersMenuChoice()) {
                            case 1:
                                showCompetitiveSwimmers();
                                break;
                            case 2:
                                showTrainingsresult();
                                break;
                            case 3:
                                editTrainingsresult();
                                break;
                            case 4:
                                quit = true;
                                start();
                                break;
                            case 0:
                                quit = true;
                                break;
                        }
                    } while (!quit);
                    break;
                case 6:
                    ui.showCompetitionMenu();
                    do {
                        switch (ui.competitionMenuChoice()) {
                            case 1:
                                showSwimmersInCompetition();
                                break;
                            case 2:
                                showCompetitionResults();
                                break;
                            case 3:
                                editCompetitionResults();
                                break;
                            case 4:
                                quit = true;
                                start();
                                break;
                            case 0:
                                quit = true;
                        }
                    } while (!quit);
                    break;
                case 0:
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    private void createMember() {
        ui.scanString();
        ui.print("Please enter first name: ");
        String firstName = ui.scanString();
        ui.print("Please enter last name: ");
        String lastName = ui.scanString();
        ui.print("Please enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = ui.scanDate();
        ui.print("Is the member an active member? Press Y for yes, or N for no: ");
        boolean isActive = ui.scanBoolean();
        int ID = db.getID();

        Member member = new Member(firstName, lastName, dateOfBirth, isActive, ID);

        db.saveMember(member);
        ui.print("The following member has been added: " + member.toString());
    }

    private void deleteMember() {
        showMembersList();
        ui.print("Enter the ID of the member you want to delete: ");
        int id = ui.scanInt();
        db.deleteMember(id);
    }

    private void showMembersList() {
        ArrayList<Member> members = db.getMembersList();
        ui.showMemberList(members);
    }

    private void editMember() {
        ui.print("Enter the ID of the member, you would like to edit: ");
        int id = ui.scanID();
        Member member = getMemberbyID(id);
        if (member == null) {
            editMemberNull(member);
        }

        boolean quit = false;
        ui.showEditMemberMenu();
        while (!quit) {
            int choice = ui.editMemberChoice();
            switch (choice) {
                case 1:
                    String firstName = ui.scanString();
                    member.setFirstName(firstName);
                    break;
                case 2:
                    String lastName = ui.scanString();
                    member.setLastName(lastName);
                    break;
                case 3:
                    ui.print("Is the member an active member? Press Y for yes, or N for no: ");
                    boolean isActive = ui.scanBoolean();
                    member.setIsActive(isActive);
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    private void showTop5Swimmers() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmer = db.getTop5();
        ui.showTop5(competitiveSwimmer);
    }

    private void showContingent() {
        ArrayList<Contingent> contingent = db.getContingentList();
        ui.showContingentList(contingent);
    }

    private void editContingent() {
        showContingent();
        
        boolean quit = false;
        ui.showEditContingentMenu();
        do {
            switch (ui.editContingentChoice()) {
                case 1:
                    editUnder18();
                    break;
                case 2:
                    editBetween18And60();
                    break;
                case 3:
                    editOver60();
                    break;
                case 4:
                    editPassive();
                    break;
                case 9:
                    quit = true;
                    start();
                    break;
                case 0:
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    private void showSwimmersInRestance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editRestance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showCompetitiveSwimmers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showTrainingsresult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editTrainingsresult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showSwimmersInCompetition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showCompetitionResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editCompetitionResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Member getMemberbyID(int id) {
        ArrayList<Member> members = db.getMembersList();
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    private void editMemberNull(Member member) {
        while (member == null) {
            ui.print("Invalid ID, please try again: ");
            int id = ui.scanID();
            member = getMemberbyID(id);
        }
    }

    private void editUnder18() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editBetween18And60() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editOver60() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editPassive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
