package main;

import businesslogic.Controller;
import datalag.DBConnection;
import datalag.DBFacade;
import datalag.DBStorage;
import java.sql.SQLException;
import presentation.SystemUI;
import presentation.UI;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class SP4Gruppe1 {

    public static void main(String[] args) throws SQLException {
        UI ui = new SystemUI();

        DBConnection dbc = new DBConnection();
        DBStorage db = new DBFacade(dbc);

        Controller ctrl = new Controller(ui, db);
        ctrl.start();
    }

}