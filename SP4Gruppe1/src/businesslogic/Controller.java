package businesslogic;

import datalag.DBFacade;
import presentation.UI;

/*
 * @author Caroline, Rikke & Nina
 */
public class Controller {

    private UI ui;
    private DBFacade db;

    public Controller(UI ui, DBFacade db) {
        this.ui = ui;
        this.db = db;
    }

    public void createMember() {
        ui.print("Please input first name: ");
        String firstName = ui.scanString();
        ui.print("Please input last name: ");
        String lastName = ui.scanString();
        ui.print("Please enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = ui.scanString();
        ui.print("Is the member an active member? Press Y for yes, or N for no: ");
        boolean isActive = ui.scanBoolean();
        int ID = db.getID();
        
        Member member = new Member(firstName, lastName, dateOfBirth, isActive, ID);
        
        db.saveMember(member);
        
    }
    
}
