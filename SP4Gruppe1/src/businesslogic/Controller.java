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
                                ui.showMembersMenu();
                                break;
                            case 2:
                                createMember();
                                ui.showMembersMenu();
                                break;
                            case 3:
                                editMember();
                                ui.showMainMenu();
                                break;
                            case 4:
                                deleteMember();
                                ui.showMainMenu();
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
                                ui.showContingentMenu();
                                break;
                            case 2:
                                ui.showEditContingentMenu();
                                do {
                                    switch (ui.editContingentChoice()) {
                                        case 1:
                                            editUnder18();
                                            ui.showEditContingentMenu();
                                            break;
                                        case 2:
                                            editBetween18And60();
                                            ui.showEditContingentMenu();
                                            break;
                                        case 3:
                                            editOver60();
                                            ui.showEditContingentMenu();
                                            break;
                                        case 4:
                                            editPassive();
                                            ui.showEditContingentMenu();
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
                                ui.showRestanceMenu();
                                break;
                            case 2:
                                editRestance();
                                ui.showRestanceMenu();
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
                                ui.showCompetitiveSwimmersMenu();
                                break;
                            case 2:
                                showTrainingsresult();
                                ui.showCompetitiveSwimmersMenu();
                                break;
                            case 3:
                                editTrainingsresult();
                                ui.showCompetitiveSwimmersMenu();
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
                                ui.showCompetitionMenu();
                                break;
                            case 2:
                                showCompetitionResults();
                                ui.showCompetitionMenu();
                                break;
                            case 3:
                                editCompetitionResults();
                                ui.showCompetitionMenu();
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
        showMembersList();
        ui.print("Enter the ID of the member, you would like to edit: ");
        int id = ui.scanID();
        Member memberByID = db.getMemberById(id);
        ui.print(memberByID.toString());

        boolean quit = false;
        ui.showEditMemberMenu();
        do {
            switch (ui.editMemberChoice()) {
                case 1:
                    ui.scanString();
                    ui.print(memberByID.toString());
                    ui.print("What would you like to change the first name to?");
                    String firstName = ui.scanString();
                    db.editFirstName(id, firstName);
                    ui.print("The first name has now been changed to " + firstName);
                    break;
                case 2:
                    ui.scanString();
                    ui.print(memberByID.toString());
                    ui.print("What would you like to change the last name to?");
                    String lastName = ui.scanString();
                    db.editLastName(id, lastName);
                    ui.print("The last name has now been changed to " + lastName);
                    break;
                case 3:
                    ui.scanString();
                    ui.print(memberByID.toString());
                    ui.print("Is the member an active member? Press Y for yes, or N for no: ");
                    boolean isActive = ui.scanBoolean();
                    db.editActiveness(id, isActive);
                    ui.print("The activeness has now been changed to " + isActive);
                    break;
                case 0:
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

//    private Member getMemberbyID(int id) {
//        ArrayList<Member> members = db.getMembersList();
//        for (Member member : members) {
//            if (member.getId() == id) {
//                return member;
//            }
//        }
//        return null;
//    }
//    private void editMemberNull(Member member) {
//        while (member == null) {
//            ui.print("Invalid ID, please try again: ");
//            int id = ui.scanID();
//            member = getMemberbyID(id);
//        }
//    }
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
        db.editRestance(id, newRestance);
        ui.print("The restance has now been changed to " + newRestance);
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
        ArrayList<CompetitiveSwimmer> competitiveSwimmers = db.getCompetitionSwimmers();
        ui.showSwimmersInCompetition(competitiveSwimmers);
    }

    private void showCompetitionResults() {
        ArrayList<CompetitiveSwimmer> competitionResults = db.getCompetitionResult();
        ui.showCompetitionResults(competitionResults);

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
