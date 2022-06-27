/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Teacher_Achivement {
    private int achivement_id;
    private String content;
    private int teacher_id;

    public Teacher_Achivement() {
    }

    public Teacher_Achivement(int achivement_id, String content, int teacher_id) {
        this.achivement_id = achivement_id;
        this.content = content;
        this.teacher_id = teacher_id;
    }

    public int getAchivement_id() {
        return achivement_id;
    }

    public void setAchivement_id(int achivement_id) {
        this.achivement_id = achivement_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Teacher_Achivement{" + "achivement_id=" + achivement_id + ", content=" + content + ", teacher_id=" + teacher_id + '}';
    }
    
    
}
