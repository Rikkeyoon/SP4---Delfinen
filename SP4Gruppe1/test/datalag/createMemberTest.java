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
        String[] input = {""};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);

        // act
        ctrl.createMember();
        
        // assert
        
    }


}
