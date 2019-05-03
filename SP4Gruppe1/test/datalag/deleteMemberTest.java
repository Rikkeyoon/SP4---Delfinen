package datalag;

import businesslogic.Controller;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Rikke, Kristine, Caroline & Nina
 */
public class deleteMemberTest {

    @Test
    public void TestDeleteMember() {
        String[] input = {""};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.deleteMember();

        // assert
        
    }

}
