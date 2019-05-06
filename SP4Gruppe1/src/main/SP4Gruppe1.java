package main;

import businesslogic.Controller;
import datalag.DBConnection;
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
                
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        
        Controller ctrl = new Controller(ui, db);
//        ctrl.createMember();
//        ctrl.deleteMember();
//        ctrl.createMember();
//        ctrl.deleteMember();
//        ctrl.showMemberList();
//        System.out.println(db.getCompetitiveSwimmersList());
          System.out.println("");
          ctrl.start();
        
    }

}
