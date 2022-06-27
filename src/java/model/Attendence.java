/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Attendence {

    private int student_id;
    private String check_date;
    private int status;
    private int teacher_id;

    public Attendence() {
    }

    public Attendence(int student_id, String check_date, int status, int teacher_id) {
        this.student_id = student_id;
        this.check_date = check_date;
        this.status = status;
        this.teacher_id = teacher_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Attendence{" + "student_id=" + student_id + ", check_date=" + check_date + ", status=" + status + ", teacher_id=" + teacher_id + '}';
    }

}
