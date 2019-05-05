package datalag;

import businesslogic.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * @author Caroline, Rikke & Nina
 */
public class DBFacade {

    private Connection connection;

    public DBFacade(DBConnection dbc) {
        connection = dbc.getConnection();
    }

    public int getID() {
        int id = 0;
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT LAST_INSERT_ID() FROM members";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
        }
        return id;
    }

    public ArrayList<Member> getMembersList() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT * FROM members ORDER BY first_name";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                String firstName = result.getString(1);
                String lastName = result.getString(2);
                int age = result.getInt(3);
                boolean isActive = result.getBoolean(4);
                int id = result.getInt(5);
                int contingent = result.getInt(6);
                int restance = result.getInt(7);

                //create a new Member object and insert it into the ArrayList
                members.add(new Member(firstName, lastName, age, isActive, contingent, restance, id));
            }
        } catch (SQLException e) {
        }
        return members;
    }

    public void saveMember(Member member) {
        try {
            //create String for the PreparedStatement
            String insertSQL = "INSERT INTO members "
                    + "(first_name, last_name, age, is_active, "
                    + "contingent, restance) VALUES"
                    + "(?, ?, ?, ?, ?, ?)";

            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            //insert correct values into the placeholders' (the ?) spaces
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setInt(3, member.getAge());
            preparedStatement.setBoolean(4, member.isIsActive());
            preparedStatement.setDouble(5, member.getContingent());
            preparedStatement.setDouble(6, member.getRestance());

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteMember(int id) {
        try {
            deleteFromCompetition(id);
            deleteFromCompetitiveSwimmers(id);
            //create String for the PreparedStatement
            String deleteSQL = "DELETE FROM members WHERE id = ?";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            //insert correct values into the placeholder's (the ?) space
            preparedStatement.setInt(1, id);

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    private void deleteFromCompetition(int id) {
        try {
            //create String for the PreparedStatement
            String deleteSQL = "DELETE FROM competitions WHERE id = ?";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            //insert correct values into the placeholder's (the ?) space
            preparedStatement.setInt(1, id);

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    private void deleteFromCompetitiveSwimmers(int id) {
        try {
            //create String for the PreparedStatement
            String deleteSQL = "DELETE FROM competitive_swimmers WHERE id = ?";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            //insert correct values into the placeholder's (the ?) space
            preparedStatement.setInt(1, id);

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public ArrayList<Member> getCompetitiveSwimmersList() {
        ArrayList<Member> swimmers = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT * FROM competitive_swimmers"
                    + "NATURAL JOIN members";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int id = result.getInt(1);
                String firstName = result.getString(5);
                String lastName = result.getString(6);
                int age = result.getInt(7);
                boolean isActive = result.getBoolean(8);
                int contingent = result.getInt(9);
                int restance = result.getInt(10);

                //create a new Member object and insert it into the ArrayList
                swimmers.add(new Member(firstName, lastName, age, isActive, contingent, restance, id));
            }
        } catch (SQLException e) {
        }
        return swimmers;
    }

    public void saveCompetitiveSwimmer(CompetitiveSwimmer member) {
        try {
            saveMember(member);
            //create String for the PreparedStatement
            String insertSQL = "INSERT INTO competitive_swimmer "
                    + "VALUES (?, ?, ?, ?)";

            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            //insert correct values into the placeholders' (the ?) spaces
            preparedStatement.setInt(1, member.getId());
            preparedStatement.setString(2, member.getDisciplin());
            preparedStatement.setTime(3, member.getBestTime());
            preparedStatement.setTimestamp(4, member.getDateOfBestTime());

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
