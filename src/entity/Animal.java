package entity;

import java.util.ArrayList;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class Animal {

    //private properties:
    private static int idNum;
    private String name;
    private int typeId;
    private String breed;
    private String description;
    private ArrayList<Note> notes;


    //constructors:

    public Animal(String name, int typeId, String breed, String description) {

        //idNum = idNum + 1;
        this.name = name;
        this.typeId = typeId;
        this.breed = breed;
        this.description = description;
        //this.notesId = notesId;
    }

    public Animal(int idNum, String name, int typeId, String breed, String description) {

        //idNum = idNum + 1;
        this.name = name;
        this.typeId = typeId;
        this.breed = breed;
        this.description = description;
        //this.notesId = notesId;
    }

//

    public String toString() {
        return String.format("%s %s %s", idNum, this.name, this.typeId);
    }

    //settin':
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDescription(String description) {
        this.description = breed;
    }

//    public void setNotesId(int notesId) {
//
//        this.notesId = notesId;
//    }

    //gettin':
    public int getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getBreed() {
        return breed;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Note> getNote() {return notes;}

    //public int getNotesId() {
       // return notesId; }

}
