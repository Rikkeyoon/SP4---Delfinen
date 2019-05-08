package businesslogic;

import datalag.FakeDBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Caroline, Nina, Kristine & Rikke
 */
public class editContingentTest {
    
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
        assertTrue(ui.output.get(5).contains("changed"));
    }
}
