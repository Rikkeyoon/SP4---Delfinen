package datalag;

import businesslogic.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;

/*
 * @author Caroline, Nina, Rikke og Kristine
 */
public class DBFacade implements DBStorage{

    private Connection connection;

    public DBFacade(DBConnection dbc) {
        connection = dbc.getConnection();
    }

    @Override
    public int getID() {
        int id = 1;
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
        } catch (SQLException | NullPointerException e) {
        }
        return id;
    }

    @Override
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
        } catch (SQLException | NullPointerException e) {
        }
        return members;
    }

    @Override
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
        } catch (SQLException | NullPointerException e) {
        }
    }

    @Override
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
        } catch (SQLException | NullPointerException e) {
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
        } catch (SQLException | NullPointerException e) {
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
        } catch (SQLException | NullPointerException e) {
        }
    }

    @Override
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
            preparedStatement.setObject(3, member.getBestTime());
            preparedStatement.setObject(4, member.getDateOfBestTime());
            //execute the SQL query
            preparedStatement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
        }
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getTop5() {
        ArrayList<CompetitiveSwimmer> top5 = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT id, first_name, last_name, age, disciplin, "
                    + "best_time, date_of_best_time FROM members"
                    + "NATURAL JOIN competitive_swimmers ORDER BY best_time"
                    + "LIMIT 5";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int id = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                int age = result.getInt(4);
                String disciplin = result.getString(5);
                Time bestTime = result.getTime(6);
                Date dateOfBestTime = result.getDate(7);

                //create a new Member object and insert it into the ArrayList
//                top5.add(new CompetitiveSwimmer(firstName, lastName, age, id, disciplin,
//                        bestTime, dateOfBestTime));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return top5;
    }

    @Override
    public ArrayList<Contingent> getContingentList() {
        ArrayList<Contingent> contingent = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT * FROM contingent";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int under18 = result.getInt(1);
                int between18And60 = result.getInt(2);
                int over60 = result.getInt(3);
                int passive = result.getInt(4);

                //create a new Member object and insert it into the ArrayList
                contingent.add(new Contingent(under18, between18And60, over60, passive));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return contingent;
    }

    @Override
    public ArrayList<Member> getMembersInRestance() {
        ArrayList<Member> membersInRestance = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT * FROM members  WHERE restance != 0 "
                    + "ORDER BY first_name";
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
                membersInRestance.add(new Member(firstName, lastName, age,
                        isActive, contingent, restance, id));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return membersInRestance;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmers() {
        ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT id, first_name, last_name, age, disciplin, "
                    + "best_time, date_of_best_time FROM members"
                    + "NATURAL JOIN competitive_swimmers";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int id = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                int age = result.getInt(4);
                String disciplin = result.getString(5);
                Time bestTime = result.getTime(6);
                Timestamp dateOfBestTime = result.getTimestamp(7);

                //create a new Member object and insert it into the ArrayList
//                competitiveSwimmers.add(new CompetitiveSwimmer(firstName, lastName, age, id, disciplin,
//                        bestTime, dateOfBestTime));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return competitiveSwimmers;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getTrainingsresult() {
        ArrayList<CompetitiveSwimmer> trainingresults = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT id, first_name, last_name, age, disciplin, "
                    + "best_time, date_of_best_time FROM members"
                    + "NATURAL JOIN competitive_swimmers"
                    + "ORDER BY best_time";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int id = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                int age = result.getInt(4);
                String disciplin = result.getString(5);
                Time bestTime = result.getTime(6);
                Timestamp dateOfBestTime = result.getTimestamp(7);

//                trainingresults.add(new CompetitiveSwimmer(firstName, lastName, age, id, disciplin,
//                        bestTime, dateOfBestTime));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return trainingresults;
    }

    @Override
    public int editUnder18(int contingent) {
        try {
            String UpdateSQL = "UPDATE contingent SET under_18 = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setInt(1, contingent);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
        return contingent;

    }

    @Override
    public int editBetween18And60(int contingent) {
        try {
            String UpdateSQL = "UPDATE contingent SET between_18_and_60 = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setInt(1, contingent);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
        return contingent;
    }

    @Override
    public int editOver60(int contingent) {
        try {
            String UpdateSQL = "UPDATE contingent SET over_60 = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setInt(1, contingent);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
        return contingent;
    }

    @Override
    public int editPassive(int contingent) {
        try {
            String UpdateSQL = "UPDATE contingent SET passive = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setInt(1, contingent);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
        return contingent;
    }

    @Override
    public Member getMemberById(int id) {
        Member member = null;
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT * FROM members WHERE id = " + id;
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                String firstName = result.getString(1);
                String lastName = result.getString(2);
                int age = result.getInt(3);
                boolean isActive = result.getBoolean(4);
                int contingent = result.getInt(6);
                int restance = result.getInt(7);

                //create a new Member object and insert it into the ArrayList
                member = new Member(firstName, lastName, age, isActive, contingent, restance, id);
            }
        } catch (SQLException | NullPointerException e) {
        }
        return member;
    }

    @Override
    public void editRestance(int id, int newRestance) {
        try {
            String UpdateSQL = "UPDATE members SET restance = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setInt(1, newRestance);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    }

    @Override
    public void editFirstName(int id, String firstName) {
        try {
            String UpdateSQL = "UPDATE members SET first_name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    }

    @Override
    public void editLastName(int id, String lastName) {
        try {
            String UpdateSQL = "UPDATE members SET last_name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    }

    @Override
    public void editActiveness(int id, boolean active) {
        try {
            String UpdateSQL = "UPDATE members SET is_active = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateSQL);
            preparedStatement.setBoolean(1, active);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
    
    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionSwimmers() {
        ArrayList<CompetitiveSwimmer> competitionSwimmers = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT id, first_name, last_name, age, disciplin,"
                    + "best_time, date_of_best_time, competition_name, ranking, "
                    + "best_time FROM members NATURAL JOIN competitive_swimmers"
                    + "NATURAL JOIN competitions ORDER BY id";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                int id = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                int age = result.getInt(4);
                String disciplin = result.getString(5);
                Time bestTime = result.getTime(6);
                Timestamp dateOfBestTime = result.getTimestamp(7);
                String competitionName = result.getString(8);
                int ranking = result.getInt(9);
                Time bestTimeInCompetition = result.getTime(10);

                //create a new Member object and insert it into the ArrayList
//                Competition competition = new Competition(competitionName, ranking, bestTimeInCompetition);
//                competitionSwimmers.add(new CompetitiveSwimmer(disciplin, bestTime, dateOfBestTime, competition, firstName, lastName, age, id));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return competitionSwimmers;
    }

    @Override
    public ArrayList<CompetitiveSwimmer> getCompetitionResult() {
        ArrayList<CompetitiveSwimmer> competitionResults = new ArrayList<>();
        try {
            //create String for the PreparedStatement
            String selectSQL = "SELECT best_time, ranking, competition_name, id,"
                    + " first_name, last_name, age, disciplin, best_time, "
                    + "date_of_best_time FROM members NATURAL JOIN "
                    + "competitive_swimmers NATURAL JOIN competitions "
                    + "ORDER BY best_time";
            //get connection
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            //execute the SQL query
            ResultSet result = preparedStatement.executeQuery(selectSQL);
            while (result.next()) {
                Time bestTimeInCompetition = result.getTime(1);
                int ranking = result.getInt(2);
                String competitionName = result.getString(3);
                int id = result.getInt(4);
                String firstName = result.getString(5);
                String lastName = result.getString(6);
                int age = result.getInt(7);
                String disciplin = result.getString(8);
                Time bestTime = result.getTime(9);
                Timestamp dateOfBestTime = result.getTimestamp(10);
                

                //create a new Member object and insert it into the ArrayList
//                Competition competition = new Competition(competitionName, ranking, bestTimeInCompetition);
//                competitionResults.add(new CompetitiveSwimmer(disciplin, bestTime, dateOfBestTime, competition, firstName, lastName, age, id));
            }
        } catch (SQLException | NullPointerException e) {
        }
        return competitionResults;
    }

}
