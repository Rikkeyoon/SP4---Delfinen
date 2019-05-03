package datalag;

import businesslogic.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * @author Caroline, Rikke & Nina
 */
public class DBFacade {

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String IP = "localhost";
    private final String PORT = "3306";
    private final String DATABASE = "delfinen";
    private final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE
            + "?useJDBCcompliantTimeZoneShift=true&"
            + "useLegacyDatetimeCode=false&serverTimezone=UTC";

    public int getID() {
        int ID = 0;
         try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() FROM members");
            while (result.next()) {
                ID = result.getInt(1);
            }
        } catch (SQLException e) {}
         return ID;
    }
    
    public void saveMember(Member member) {
        int isActiveInt = convertBooleanToTinyInt(member);
        
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            statement.executeUpdate("INSERT INTO members (first_name, last_name, "
                    + "age, is_active, contingent, restance) "
                    + "VALUES ('" + member.getFirstName() + "', '" + member.getLastName() + "', "
                    + member.getAge() + ", " + isActiveInt +
                    ", " + member.getContingent() + ", " + member.getRestance() + ")");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    private int convertBooleanToTinyInt(Member member) {
        if (member.isIsActive()) {
            return 1;
        }
        return 0;
    }

    public void deleteMember(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeLargeUpdate("DELETE FROM competitions WHERE id =" + id);
            statement.executeLargeUpdate("DELETE FROM competitive_swimmers WHERE id =" + id);
            statement.executeLargeUpdate("DELETE FROM members WHERE id =" + id);
        } catch (SQLException e) {}
    }

    public ArrayList<Member> getMemberList() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM members");
            while (result.next()) {
                String firstName = result.getString(1);
                String lastName = result.getString(2);
                int age = result.getInt(3);
                boolean isActive = result.getBoolean(4);
                int contingent = result.getInt(5);
                int restance = result.getInt(6);

                members.add(new Member(firstName, lastName, age, isActive, contingent, restance));
            }
        } catch (SQLException e) {

        }
        return members;
    }
}
