package repository;

import entity.Note;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrewdmo on 9/12/16.
 */
public class NoteRepository {
    private Connection conn;

    public NoteRepository(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }


    public Note createNote(String text, int animalId) throws SQLException {

        //Note newNote = new Note;
        Note newNote = new Note(text, animalId);

        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO notes" +
                "(timestamp, " +
                "text," +
                "animal_fk)" +
                "VALUES (?,?,?) RETURNING notes_pk"
        );

        stmt.setString(1, new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        stmt.setString(2, text);
        stmt.setInt(3, animalId);

        ResultSet newNoteResult = stmt.executeQuery();

        // set the ID of the widget I just persisted
        newNote.setNoteNum(newNoteResult.getInt("notes_pk"));
        return newNote;
    }

    public boolean deleteNote(int noteId) throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM notes " +
                "WHERE note_pk = ?"
        );

        stmt.setInt(1, noteId);
        stmt.executeUpdate();
        return true;
    }


    public ResultSet noteList(int animalId) throws SQLException {

        PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM note WHERE animal_fk = ?"
        );

        stmt.setInt(1, animalId);

        return stmt.executeQuery();
    }
}