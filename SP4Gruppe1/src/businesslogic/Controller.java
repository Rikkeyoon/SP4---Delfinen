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
                                showMembersInRestance();
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
        String firstName = ui.scanName();
        ui.print("Please enter last name: ");
        String lastName = ui.scanName();
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
        ui.print("The member with ID number " + id + " has been deleted");
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
        do {
            switch (ui.editMemberChoice()) {
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
        } while (!quit);
    }

    private void showTop5Swimmers() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmers = db.getTop5();
        ui.showTop5(competitiveSwimmers);
    }

    private void showContingent() {
        ArrayList<Contingent> contingent = db.getContingentList();
        ui.showContingentList(contingent);
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

    private void showMembersInRestance() {
        ArrayList<Member> membersInRestance = db.getMembersInRestance();
        ui.showMemberList(membersInRestance);
    }

    private void editRestance() {
        showMembersList();
        ui.print("\nEnter the ID of the member, you would like to edit:");
        int id = ui.scanID();
        Member memberByID = db.getMemberById(id);
        ui.print(memberByID.toString());
        ui.print("\nWhat would you like to change the restance to?");
        int newRestance = ui.scanInt();
        newRestance = db.editRestance(id, newRestance);
        ui.print("The restance has now been changed to " + newRestance);
    }
    
    private Member getMemberById(int id) {
        Member memberById = db.getMemberById(id);
        return memberById;
    }

    private void showCompetitiveSwimmers() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmers = db.getCompetitiveSwimmers();
        ui.showCompetitiveSwimmerList(competitiveSwimmers);
    }

    private void showTrainingsresult() {
        ArrayList<CompetitiveSwimmer> trainingresults = db.getTrainingsresult();
        ui.showTrainingresults(trainingresults);
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

    private void editUnder18() {
        ui.print("What would you change the contingent to?");
        int contingent = ui.scanInt();
        contingent = db.editUnder18(contingent);
        ui.print("The contingent has now been changed to " + contingent);
    }

    private void editBetween18And60() {
        ui.print("What would you change the contingent to?");
        int contingent = ui.scanInt();
        contingent = db.editBetween18And60(contingent);
        ui.print("The contingent has now been changed to " + contingent);
    }

    private void editOver60() {
        ui.print("What would you change the contingent to?");
        int contingent = ui.scanInt();
        contingent = db.editOver60(contingent);
        ui.print("The contingent has now been changed to " + contingent);
    }

    private void editPassive() {
        ui.print("What would you change the contingent to?");
        int contingent = ui.scanInt();
        contingent = db.editPassive(contingent);
        ui.print("The contingent has now been changed " + contingent);
    }
}
