package repository; /**
 * Created by andrewdmo on 9/11/16.
 */

import java.sql.*;


public class AnimalTypeRepository {

        private Connection conn;

        public AnimalTypeRepository(String jdbcUrl) throws SQLException {
            this.conn = DriverManager.getConnection(jdbcUrl);
        }

    //
    public ResultSet listType() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT animaltypename FROM animaltype");
    }

    public String TypeNamesFromId (int typeNum) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT animaltypename " +
                "FROM animaltype " +
                "WHERE animaltype_pk = ?"
        );

        stmt.setInt(1, typeNum);

        ResultSet newResult = stmt.executeQuery();

        while(newResult.next()) {
           return newResult.getString("animaltypename").toLowerCase();
        }
        return "FAIL";
    }

    public int SingleTypeIdFromName (String typeName) throws SQLException {
        int animalType = 0;

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT animaltype_pk FROM animaltype WHERE " + typeName.equalsIgnoreCase(typeName));
            while (rs.next()) {
                animalType = rs.getInt(("animaltype_pk"));
                return animalType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animalType;
    }

    public String SingleTypeNameFromId (int typeId) throws SQLException {

        String animalType = null;

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT animaltypename FROM animaltype WHERE " + typeId);
            //while (rs.next()) {
                animalType = rs.getString("animaltypename");
              //  return animalType;
           //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animalType;
    }

    public ResultSet AnimalTypeIdsFromName (String typeName) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT animaltype_pk FROM animaltype WHERE ? = ?);
        stmt.setString(1, "animaltypename");
                    2, typeName.toLowerCase());
stmt.
        return stmt.executeQuery();

    }
}

