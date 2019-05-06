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
    }

    private void deleteMember() {
        showMembersList();
        ui.print("Enter the ID of the member you want to delete: ");
        int id = ui.scanInt();
        db.deleteMember(id);
    }

    private void showMembersList() {
        ArrayList<Member> members = db.getMembersList();
        // muligvis sorter medlemmer i forhold til ID eller alfabetisk?
        ui.showMemberList(members);
    }

    private void editMember() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showTop5Swimmers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showContingent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editContingent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
