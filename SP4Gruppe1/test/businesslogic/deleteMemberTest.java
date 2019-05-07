package businesslogic;

import datalag.DBConnection;
import datalag.DBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Rikke, Kristine, Caroline & Nina
 */
public class deleteMemberTest {

    @Test
    public void TestDeleteMember() {
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12", "y", 
            "4", "1", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();

        // assert
        assertTrue(ui.output.get(9).contains("deleted"));
        
    }

}
