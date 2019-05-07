package businesslogic;

import datalag.DBConnection;
import datalag.DBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;
/*
 * @author Caroline, Rikke, Nina & Kristine
 */
public class createMemberTest {

    @Test
    public void testCreateMember() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(6).contains("Ole Jensen"));
    }
    
    @Test
    public void testCreateMember_create2Members() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "2", "", "Mia", "Jensen", "1989-12-12",
            "y", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(6).contains("Ole Jensen"));
        assertTrue(ui.output.get(11).contains("Mia Jensen"));
    }

}
