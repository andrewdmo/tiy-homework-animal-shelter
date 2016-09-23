package service;

import entity.Note;
import repository.NoteRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by andrewdmo on 9/16/16.
 */
public class NoteService {

    private NoteRepository noteRepository;

    public void createNote(int animalId, String noteText) throws SQLException {
        noteRepository.createNote(noteText, animalId);
    }

    public void deleteNote(int noteId) throws IOException, SQLException {
        noteRepository.deleteNote(noteId);
    }

    public ArrayList<Note> listNotes(int animalId) {
        ArrayList<Note> noteList = new ArrayList<>();

        try {
            ResultSet noteResult = noteRepository.noteList(animalId);

            while (noteResult.next()) {
                Note currentNote = new Note(
                    noteResult.getInt("notes_pk"),
                    noteResult.getString("text"),
                    noteResult.getInt("animal_fk"),
                    noteResult.getString("timestamp"
                    ));

                noteList.add(currentNote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteList;

    }
}


