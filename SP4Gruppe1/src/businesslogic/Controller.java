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
        String firstName = ui.scanString();
        String lastName = ui.scanString();
        String dateOfBirth = ui.scanString();
        boolean isActive = ui.scanBoolean();
        int ID = db.getID();
        
        Member member = new Member(firstName, lastName, dateOfBirth, isActive, ID);
        
        db.saveMember(member);
        
    }
    
}
