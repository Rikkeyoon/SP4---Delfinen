package datalag;

import businesslogic.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void saveMember(Member member) {
        try {
            //create String for the PreparedStatement
            String insertSQL = "INSERT INTO members "
                    + "(first_name, last_name, age, is_active, "
                    + "contingent, restance) VALUES"
                    + "(?, ?, ?, ?, ?, ?)";

            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            //insert correct values into the placeholders' ( the ?) spaces
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
            //insert correct values into the placeholder's ( the ?) space
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
            //insert correct values into the placeholder's ( the ?) space
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
            //insert correct values into the placeholder's ( the ?) space
            preparedStatement.setInt(1, id);

            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
