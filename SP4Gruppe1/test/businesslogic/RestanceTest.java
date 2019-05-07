package businesslogic;

import datalag.DBConnection;
import datalag.DBFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author carol
 */
public class RestanceTest {

    @Test
    public void testRestance_editRestance() {
        // arrange
        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
            "y", "5", "3", "2", "1", "700", "0"};
        FakeUI ui = new FakeUI(input);
        DBConnection dbc = new DBConnection();
        DBFacade db = new DBFacade(dbc);
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.start();

        // assert
        assertTrue(ui.output.get(13).contains("The restance has now been changed to 700"));
    }

//    @Test
//    public void testRestance_showMembersInRestance() {
//        // arrange
//        String[] input = {"", "1", "2", "", "Ole", "Jensen", "1989-12-12",
//            "y", "5", "3", "2", "1", "700", "0"};
//        FakeUI ui = new FakeUI(input);
//        DBConnection dbc = new DBConnection();
//        DBFacade db = new DBFacade(dbc);
//        Controller ctrl = new Controller(ui, db);
//
//        // act
//        ctrl.start();
//
//        // assert
//        assertTrue(ui.output.get(6).contains("Ole Jensen"));
//    }

}
