package datalag;

import businesslogic.CompetitiveSwimmer;
import businesslogic.Contingent;
import businesslogic.Member;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caroline, Nina, Rikke og Kristina
 */
public class FakeDBFacadeTest {

    /**
     * Test of getID method, of class FakeDBFacade.
     */
    @Test
    public void testGetID() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        int expResult = 1;
        //act
        int result = db.getID();
        //assert
        assertEquals(expResult, result);
    }

    /**
     * Test of saveMember method, of class FakeDBFacade.
     */
    @Test
    public void testSaveMember() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        //act
        db.saveMember(m1);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertTrue(members.get(0).equals(m1));
        assertTrue(members.size() == 1);
    }

    /**
     * Test of getMembersList method, of class FakeDBFacade.
     */
    @Test
    public void testGetMembersList() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        Member m2 = new Member("Mia", "Jensen", 40, false, 500, 0, 2);
        Member m3 = new Member("Sofia", "Jensen", 12, true, 1000, 0, 3);
        //act
        db.saveMember(m1);
        db.saveMember(m2);
        db.saveMember(m3);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertTrue(members.get(0).equals(m1));
        assertTrue(members.get(1).equals(m2));
        assertTrue(members.get(2).equals(m3));
        assertTrue(members.size() == 3);
    }

    /**
     * Test of deleteMember method, of class FakeDBFacade.
     */
    @Test
    public void testDeleteMember() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        Member m2 = new Member("Mia", "Jensen", 40, false, 500, 0, 2);
        Member m3 = new Member("Sofia", "Jensen", 12, true, 1000, 0, 3);
        //act
        db.saveMember(m1);
        db.saveMember(m2);
        db.saveMember(m3);
        db.deleteMember(2);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertTrue(members.get(0).equals(m1));
        assertTrue(members.get(1).equals(m3));
        assertTrue(members.size() == 2);
    }

    /**
     * Test of saveCompetitiveSwimmer method, of class FakeDBFacade.
     */
    @Test
    public void testSaveCompetitiveSwimmer() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        LocalTime bestTime = LocalTime.parse("00:12:45");
        String dateString = "2019-05-08";
        LocalDate dateOfBestTime = LocalDate.parse(dateString);
        CompetitiveSwimmer s1 = new CompetitiveSwimmer("Sofia",
                "Jensen", 12, 3, "butterfly", bestTime, dateOfBestTime);
        //act
        db.saveCompetitiveSwimmer(s1);
        ArrayList<CompetitiveSwimmer> swimmers = db.getCompetitiveSwimmers();
        //assert
        assertTrue(swimmers.get(0).equals(s1));
        assertTrue(swimmers.size() == 1);
    }

//    /**
//     * Test of getTop5 method, of class FakeDBFacade.
//     */
//    @Test
//    public void testGetTop5() {
//        //arrange
//        FakeDBFacade db = new FakeDBFacade();
//        LocalTime bestTime1 = LocalTime.parse("00:12:45");
//        String dateOfBestTime1 = "2019-05-08";
//        CompetitiveSwimmer s1 = new CompetitiveSwimmer("Sofia",
//                "Jensen", 12, 3, "butterfly", bestTime1, dateOfBestTime1);
//        LocalTime bestTime2 = LocalTime.parse("00:10:45");
//        String dateOfBestTime2 = "2019-05-08";
//        CompetitiveSwimmer s2 = new CompetitiveSwimmer("Gerta",
//                "Jensen", 12, 3, "butterfly", bestTime2, dateOfBestTime2);
//        LocalTime bestTime3 = LocalTime.parse("00:09:45");
//        String dateOfBestTime3 = "2019-05-08";
//        CompetitiveSwimmer s3 = new CompetitiveSwimmer("Sofia",
//                "Jensen", 12, 3, "butterfly", bestTime3, dateOfBestTime3);
//        LocalTime bestTime4 = LocalTime.parse("00:11:45");
//        String dateOfBestTime4 = "2019-05-08";
//        CompetitiveSwimmer s4 = new CompetitiveSwimmer("Gerta",
//                "Jensen", 12, 3, "butterfly", bestTime4, dateOfBestTime4);
//        LocalTime bestTime5 = LocalTime.parse("00:09:00");
//        String dateOfBestTime5 = "2019-05-08";
//        CompetitiveSwimmer s5 = new CompetitiveSwimmer("Sofia",
//                "Jensen", 12, 3, "butterfly", bestTime5, dateOfBestTime5);
//        LocalTime bestTime6 = LocalTime.parse("00:03:45");
//        String dateOfBestTime6 = "2019-05-08";
//        CompetitiveSwimmer s6 = new CompetitiveSwimmer("Gerta",
//                "Jensen", 12, 3, "butterfly", bestTime6, dateOfBestTime6);
//        //act
//        db.saveCompetitiveSwimmer(s1);
//        db.saveCompetitiveSwimmer(s2);
//        db.saveCompetitiveSwimmer(s3);
//        db.saveCompetitiveSwimmer(s4);
//        db.saveCompetitiveSwimmer(s5);
//        db.saveCompetitiveSwimmer(s6);
//        ArrayList<CompetitiveSwimmer> top5 = db.getTop5();
//        //assert
//        assertTrue(top5.size() == 5);
//    }

    /**
     * Test of getMembersInRestance method, of class FakeDBFacade.
     */
    @Test
    public void testGetMembersInRestance() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        Member m2 = new Member("Mia", "Jensen", 40, false, 500, 500, 2);
        Member m3 = new Member("Sofia", "Jensen", 12, true, 1000, 0, 3);
        //act
        db.saveMember(m1);
        db.saveMember(m2);
        db.saveMember(m3);
        ArrayList<Member> membersInRestance = db.getMembersInRestance();
        //assert
        assertTrue(membersInRestance.get(0).equals(m2));
        assertTrue(membersInRestance.size() == 1);
    }

    /**
     * Test of getCompetitiveSwimmers method, of class FakeDBFacade.
     */
    @Test
    public void testGetCompetitiveSwimmers() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        LocalTime bestTime1 = LocalTime.parse("00:12:45");
        String dateString = "2019-05-08";
        LocalDate dateOfBestTime = LocalDate.parse(dateString);
        CompetitiveSwimmer s1 = new CompetitiveSwimmer("Sofia",
                "Jensen", 12, 3, "butterfly", bestTime1, dateOfBestTime);
        LocalTime bestTime2 = LocalTime.parse("00:10:45");
        CompetitiveSwimmer s2 = new CompetitiveSwimmer("Gerta",
                "Jensen", 12, 3, "butterfly", bestTime2, dateOfBestTime);
        LocalTime bestTime3 = LocalTime.parse("00:09:45");
        CompetitiveSwimmer s3 = new CompetitiveSwimmer("Sofia",
                "Jensen", 12, 3, "butterfly", bestTime3, dateOfBestTime);
        //act
        db.saveCompetitiveSwimmer(s1);
        db.saveCompetitiveSwimmer(s2);
        db.saveCompetitiveSwimmer(s3);
        ArrayList<CompetitiveSwimmer> swimmers = db.getCompetitiveSwimmers();
        //assert
        assertTrue(swimmers.get(0).equals(s1));
        assertTrue(swimmers.get(1).equals(s2));
        assertTrue(swimmers.get(2).equals(s3));
        assertTrue(swimmers.size() == 3);
    }

    /**
     * Test of getTrainingsresult method, of class FakeDBFacade.
     */
    @Test
    public void testGetTrainingsresult() {
    }

    /**
     * Test of editUnder18 method, of class FakeDBFacade.
     */
    @Test
    public void testEditUnder18() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        int newContingent = 700;
        //act
        db.editUnder18(newContingent);
        //assert
        assertTrue(db.getContingentList().get(0).toString().contains("700"));
    }

    /**
     * Test of editBetween18And60 method, of class FakeDBFacade.
     */
    @Test
    public void testEditBetween18And60() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        int newContingent = 700;
        //act
        db.editBetween18And60(newContingent);
        //assert
        assertTrue(db.getContingentList().get(0).toString().contains("700"));
    }

    /**
     * Test of editOver60 method, of class FakeDBFacade.
     */
    @Test
    public void testEditOver60() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        int newContingent = 700;
        //act
        db.editOver60(newContingent);
        //assert
        assertTrue(db.getContingentList().get(0).toString().contains("700"));
    }

    /**
     * Test of editPassive method, of class FakeDBFacade.
     */
    @Test
    public void testEditPassive() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        int newContingent = 700;
        //act
        db.editPassive(newContingent);
        //assert
        assertTrue(db.getContingentList().get(0).toString().contains("700"));
    }

    /**
     * Test of editRestance method, of class FakeDBFacade.
     */
    @Test
    public void testEditRestance() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        db.saveMember(m1);
        int newRestance = 200;
        //act
        db.editRestance(1, newRestance);
        ArrayList<Member> members = db.getMembersList();
        int restanceForM1 = (int) members.get(0).getRestance();
        //assert
        assertTrue(restanceForM1 == newRestance);
    }

    /**
     * Test of editFirstName method, of class FakeDBFacade.
     */
    @Test
    public void testEditFirstName() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        db.saveMember(m1);
        String newName = "Hans";
        //act
        db.editFirstName(1, newName);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertTrue(members.get(0).getFirstName().equals(newName));
    }
    
    /**
     * Test of editLastName method, of class FakeDBFacade.
     */
    @Test
    public void testEditLastName() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        db.saveMember(m1);
        String newName = "Hansen";
        //act
        db.editLastName(1, newName);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertTrue(members.get(0).getLastName().equals(newName));
    }

    /**
     * Test of editActiveness method, of class FakeDBFacade.
     */
    @Test
    public void testEditActiveness() {
        //arrange
        FakeDBFacade db = new FakeDBFacade();
        Member m1 = new Member("Ole", "Jensen", 48, true, 1600, 0, 1);
        db.saveMember(m1);
        boolean active = false;
        //act
        db.editActiveness(1, active);
        ArrayList<Member> members = db.getMembersList();
        //assert
        assertFalse(members.get(0).isIsActive());
    }

    /**
     * Test of getCompetitionSwimmers method, of class FakeDBFacade.
     */
    @Test
    public void testGetCompetitionSwimmers() {
    }

    /**
     * Test of getCompetitionResult method, of class FakeDBFacade.
     */
    @Test
    public void testGetCompetitionResult() {
    }

}
