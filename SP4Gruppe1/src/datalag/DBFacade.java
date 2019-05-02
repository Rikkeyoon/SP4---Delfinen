package datalag;

import businesslogic.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public void createMember(Member member) {
//        try {
//            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            Statement statement = connection.createStatement();
//
//            statement.executeLargeUpdate("INSERT INTO bestillinger(afhenttid) "
//                    + "VALUE ('" + bestilling.getAfhentTid() + "')");
////            int bestilNr = findBestilNr();
//        } catch (SQLException e) {

//        }
    }

}
