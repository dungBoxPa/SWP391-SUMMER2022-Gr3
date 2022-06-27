/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Teacher_Record {
    private int record_id; 
    private int teacher_id; 
    private String description;

    public Teacher_Record() {
    }

    public Teacher_Record(int record_id, int teacher_id, String description) {
        this.record_id = record_id;
        this.teacher_id = teacher_id;
        this.description = description;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Teacher_Record{" + "record_id=" + record_id + ", teacher_id=" + teacher_id + ", description=" + description + '}';
    }
    
    
}
