package businesslogic;

import datalag.FakeDBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Caroline, Nina, Kristine & Rikke
 */
public class editContingentTest {
    
    @Test public void testShowContingent_withFakeDB() {
        // arrange
        String[] input = {"", "2", "1", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(3).contains("Contingent"));
        
    }
    
    @Test
    public void testEditContingent_editUnder18_withFakeDB() {
        // arrange
        String[] input = {"", "2", "2", "1", "400", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(4).contains("The contingent has now been changed"));
    }
    
    @Test
    public void testEditContingent_editBetween18And60_withFakeDB() {
        // arrange
        String[] input = {"", "2", "2", "2", "400", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(4).contains("The contingent has now been changed"));
    }
    
    @Test
    public void testEditContingent_editOver60_withFakeDB() {
        // arrange
        String[] input = {"", "2", "2", "3", "400", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(4).contains("The contingent has now been changed"));
    }
    
    @Test
    public void testEditContingent_editPassive_withFakeDB() {
        // arrange
        String[] input = {"", "2", "2", "4", "400", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(4).contains("The contingent has now been changed"));
    }
}
