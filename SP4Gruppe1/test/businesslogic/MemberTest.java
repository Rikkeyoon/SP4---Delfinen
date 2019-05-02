package businesslogic;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class MemberTest {
    
    @Test
    public void testMember_calculateAge() {
        //arrange 
        Member member = new Member("", "", "2002-02-05", "", 0, true);
        //act
        int age = member.getAge();
        //assert
        assertEquals(17, age);
    }
}
