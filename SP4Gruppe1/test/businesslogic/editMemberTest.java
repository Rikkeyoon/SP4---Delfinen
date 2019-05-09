package businesslogic;

import datalag.DBConnection;
import datalag.DBFacade;
import datalag.FakeDBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Caroline, Rikke, Nina og Kristine
 */
public class editMemberTest {
    
    @Test
    public void testEditMember_editFirstName_withDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "2", "Laila", "0", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The first name has now been changed to Laila")); 
    }
    
    @Test
    public void testEditMember_editLastName_withDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "2", "Hansen", "0", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The last name has now been changed to Laila")); 
    }
    
    @Test
    public void testEditMember_editActiveness_withDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "3", "n", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The activeness has now been changed to false")); 
    }
    
    @Test
    public void testEditMember_editFirstName_withFakeDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "1", "Laila", "0", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The first name has now been changed to Laila")); 
    }
    
    @Test
    public void testEditMember_editLastName_withFakeDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "2", "Hansen", "0", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The last name has now been changed to Laila")); 
    }
    
    @Test
    public void testEditMember_editActiveness_withFakeDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "3", "1", "3", "n", "0", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(12).contains("The activeness has now been changed to false")); 
    }
}
