package businesslogic;

import datalag.FakeDBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Caroline, Nina, Rikke & Kristina
 */
public class showCompetitiveSwimmersTest {
    
    @Test
    public void showCompetitiveSwimmers_withFakeDB() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "5", "5", "2", "1", "", "butterfly", "00:37:00", "2019-05-08", 
            "1", "0"};
        FakeUI ui = new FakeUI(input);
        FakeDBFacade db = new FakeDBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(10).contains("Ole"));
    }
}
