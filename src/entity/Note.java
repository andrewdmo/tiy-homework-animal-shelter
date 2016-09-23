package entity;

/**
 * Created by andrewdmo on 9/14/16.
 */
public class Note {

    private int noteNum;
    private String timeStamp;
    private String text;
    private int animalId;

    public Note(String text, int animalId){
        this.text = text;
        this.animalId = animalId;
    }

    public Note(int noteNum, String text, int animalId, String timeStamp) {
        this.noteNum = noteNum;
        this.text = text;
        this.animalId = animalId;
        this.timeStamp = timeStamp;

    }

    public int getNoteNum() {
        return noteNum;
    }

    public String getTimestamp() {
        return timeStamp;
    }

    public String getText() {
        return text;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setNoteNum(int noteNum) {
        this.noteNum = noteNum;
    }

    public void setTimeStamp(String date) {
        this.timeStamp = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
