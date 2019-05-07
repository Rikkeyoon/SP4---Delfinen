package datalag;

import businesslogic.Controller;
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
        String[] input = {"", "1", "2", "Ole", "Jensen", "1989-12-12", "y", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();
        
        // assert
        assertTrue(ui.output.get(7).contains("Ole Jensen"));
        
    }


}
