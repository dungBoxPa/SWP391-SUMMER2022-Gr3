/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Kinder_Class {
    private int     class_id;
    private String  class_name;
    private int     grade;
    private String  class_description;
    private int     teacher_id;

    public Kinder_Class() {
    }

    public Kinder_Class(int class_id, String class_name, int grade, String class_description, int teacher_id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.grade = grade;
        this.class_description = class_description;
        this.teacher_id = teacher_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getClass_description() {
        return class_description;
    }

    public void setClass_description(String class_description) {
        this.class_description = class_description;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Class{" + "class_id=" + class_id + ", class_name=" + class_name + ", grade=" + grade + ", class_description=" + class_description + ", teacher_id=" + teacher_id + '}';
    }
    
    
}
