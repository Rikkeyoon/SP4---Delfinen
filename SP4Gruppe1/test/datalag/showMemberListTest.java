package datalag;

import businesslogic.Controller;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

/*
 * @author Rikke, Nina, Kristine & Caroline
 */
public class showMemberListTest {
    
    @Test
    public void TestShowMemberList() {
        // arrange
        String[] input = {"1", "0"};
        FakeUI ui = new FakeUI(input);
        DBFacade db = new DBFacade();
        Controller ctrl = new Controller(ui, db);
        
        // act
        ctrl.showMemberList();
        
        // assert
        assertTrue(ui.output.get(4).contains("Vesuvio"));
        
    }
    
    
}
