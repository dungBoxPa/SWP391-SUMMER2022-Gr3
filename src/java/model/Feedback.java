/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Windows 10 TIMT
 */
public class Feedback {

    private int feedback_id;
    private int kid_id;
    private int teacher_id;
    private String fb_content;
    private double rating;
    private String takenDate;

    public Feedback() {
    }

    public Feedback(int kid_id, int teacher_id, String fb_content, double rating, String takenDate) {
        this.kid_id = kid_id;
        this.teacher_id = teacher_id;
        this.fb_content = fb_content;
        this.rating = rating;
        this.takenDate = takenDate;
    }

    public Feedback(int feedback_id, int kid_id, int teacher_id, String fb_content, double rating, String takenDate) {
        this.feedback_id = feedback_id;
        this.kid_id = kid_id;
        this.teacher_id = teacher_id;
        this.fb_content = fb_content;
        this.rating = rating;
        this.takenDate = takenDate;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getKid_id() {
        return kid_id;
    }

    public void setKid_id(int kid_id) {
        this.kid_id = kid_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFb_content() {
        return fb_content;
    }

    public void setFb_content(String fb_content) {
        this.fb_content = fb_content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedback_id=" + feedback_id + ", kid_id=" + kid_id + ", teacher_id=" + teacher_id + ", fb_content=" + fb_content + ", rating=" + rating + ", takenDate=" + takenDate + '}';
    }

}
