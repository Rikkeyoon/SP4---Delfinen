package businesslogic;

import datalag.FakeDBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Nina, Rikke, Caroline & Kristina
 */
public class createCompetitiveSwimmerTest {
    
    @Test
    public void testCreateCompetitiveSwimmer() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "5", "5", "2", "1", "", "butterfly", "00:37:00", "2019-05-08", 
            "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(6).contains("The following member has been added:"));
    }
}
