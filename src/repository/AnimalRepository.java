package repository;

import entity.*;

import java.sql.*;

/**
 * Created by andrewdmo on 9/8/16.
 */
public class AnimalRepository {

    private Connection conn;

    //constructor:
    public AnimalRepository(String jdbcUrl) throws SQLException {

        this.conn = DriverManager.getConnection(jdbcUrl);
    }


    // list animals:
    public ResultSet listAnimals() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM animal");
    }


    public Animal createAnimal(Animal newAnimal) throws SQLException {
        //newAnimal = new entity.Animal

        PreparedStatement statement = conn.prepareStatement(
            "INSERT INTO animal" +
                "(animalname," +
                "animalbreed," +
                "animaldescription," +
                "animaltypeid)" +
                "VALUES(?,?,?,?) RETURNING animal_id_pk"
        );

        statement.setString(1, newAnimal.getName());
        statement.setString(2, newAnimal.getBreed());
        statement.setString(3, newAnimal
            .getDescription());
        statement.setInt(4, newAnimal.getTypeId());
        ResultSet newResult = statement.executeQuery(
        );

        // set the ID of the widget I just persisted
        while (newResult.next()) {
            newAnimal.setIdNum(newResult.getInt("animal_id_pk"));
        }
        return newAnimal;
    }


    public Animal viewAnimal(int idNum) throws SQLException {

        Statement statement = this.conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal WHERE animal_id_pk = " + idNum);

        return new Animal(
            resultSet.getInt("animal_id_pk"),
            resultSet.getString("animalname"),
            resultSet.getInt("animaltypeid"),
            resultSet.getString("animalbreed"),
            resultSet.getString("animaldescription"));
    }


    public boolean editAnimal(Animal editedAnimal) throws SQLException {


        PreparedStatement statement = conn.prepareStatement(
            "UPDATE animal SET " +
                "animalname = ?," +
                "animalbreed = ?," +
                "animaldescription = ?," +
                "animaltypeid = ?" +
                "WHERE animalname = ?"
        );

        statement.setString(1, editedAnimal.getName());
        statement.setString(2, editedAnimal.getBreed());
        statement.setString(3, editedAnimal.getDescription());
        statement.setInt(4, editedAnimal.getTypeId());
        statement.setString(5, editedAnimal.getName());
        statement.executeUpdate(
        );

        return true;
    }

    public boolean deleteAnimal(Animal delAnimal) throws SQLException {

        PreparedStatement statement = conn.prepareStatement(
            "DELETE FROM animal WHERE animalname = ?"
        );

        statement.setString(1, delAnimal.getName());
        statement.executeUpdate();
        return true;
    }


}
//Statement stmt = conn.createStatement();
//        stmt.executeQuery("INSERT INTO animal (null, newAnimal.getname(), newAnimal.gettype(),...)\n" +
//                "VALUES (value1,value2,value3,...); TO entity.Animal)
//
//            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO animal (/*null,*/ newAnimal.getName(), newAnimal.getType(), newAnimal.getBreed(), newAnimal.getDescription(), newAnimal.getNotes()");
//        preparedStatement.setString(1, name,  );

// indexNum

//animalsList.add(animal)
//persist();


//    //persist('save'):
//    private void persist() throws IOException {
//        String json = gson.toJson(animalsList);
//        Files.write(filePath, json.getBytes());


////Menu 2:
//    public void createAnimal(entity.Animal animal) throws IOException {
//        animalsList.add(animal);
//
//        persist();
//    }
//
//
//    //menu 3:
//    public entity.Animal viewAnimal(int index) {
//        return animalsList.get(index);
//    }
//
//    //menu animalShelter_v1_4:
//    public void editAnimal(int index, entity.Animal animal) throws IOException {
//        animalsList.set(index, animal);
//
//        persist();
//    }
//
//    //menu 5:
//    public void deleteAnimal(int index) throws IOException {
//        animalsList.remove(index);
//
//        persist();
//    }
//
//    public entity.Animal getAnimal(int index) {
//        return animalsList.get(index);
//    }
