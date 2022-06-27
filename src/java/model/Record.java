/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NQ
 */
public class Record {
    private int record_id;
    private int student_id;
    private String note;
    private int criteria_id;
    private String semester;

    public Record() {
    }

    public Record(int record_id, int student_id, String note, int criteria_id, String semester) {
        this.record_id = record_id;
        this.student_id = student_id;
        this.note = note;
        this.criteria_id = criteria_id;
        this.semester = semester;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCriteria_id() {
        return criteria_id;
    }

    public void setCriteria_id(int criteria_id) {
        this.criteria_id = criteria_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Record{" + "record_id=" + record_id + ", student_id=" + student_id + ", note=" + note + ", criteria_id=" + criteria_id + ", semester=" + semester + '}';
    }
    
    
}
