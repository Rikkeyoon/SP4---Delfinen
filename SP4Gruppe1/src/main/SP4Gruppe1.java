package main;

import businesslogic.Controller;
import datalag.DBFacade;
import java.sql.SQLException;
import presentation.SystemUI;
import presentation.UI;

/*
 * @author Caroline, Rikke & Nina
 */
public class SP4Gruppe1 {

    public static void main(String[] args) throws SQLException {
        UI ui = new SystemUI();
        DBFacade db = new DBFacade();
        
        Controller ctrl = new Controller(ui, db);
//        ctrl.createMember();
        ctrl.deleteMember();
        
    }

}
